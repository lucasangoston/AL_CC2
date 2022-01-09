package fr.al_cc2.web.tradesman;

import fr.al_cc2.application.tradesman.create.CreateTradesman;
import fr.al_cc2.application.tradesman.retrieve.RetrieveTradesmans;
import fr.al_cc2.domain.model.Certificates;
import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.kernel.command.CommandBus;
import fr.al_cc2.kernel.query.QueryBus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TradesmanController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public TradesmanController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/tradesmans", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TradesmansResponse> getAll() {
        final List<Tradesman> tradesmans = queryBus.send(new RetrieveTradesmans());
        TradesmansResponse tradesmansResponseResult = new TradesmansResponse(tradesmans.stream().map(tradesman -> new TradesmanResponse(String.valueOf(tradesman.getId().getValue()), tradesman.getFirstName(), tradesman.getLastName(), tradesman.getMail(), tradesman.getPassword(), tradesman.getQualification(), tradesman.getSkills(), tradesman.getGeographicalArea(),tradesman.getDailyRate(), tradesman.getBankingInfo(), new CertificatesResponse(tradesman.getCertificates().getName(), tradesman.getCertificates().getDate()))).collect(Collectors.toList()));
        return ResponseEntity.ok(tradesmansResponseResult);
    }

    @PostMapping(path = "/tradesmans/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid TradesmanRequest request) {
        CreateTradesman createTradesman = new CreateTradesman(request.firstname, request.lastname, request.mail, request.password, request.qualification, request.skills, request.geographicalArea, request.dailyRate, request.bankingInfo, new Certificates(request.certificates.getName(), request.certificates.getDate()));
        TradesmanId tradesmanId = commandBus.send(createTradesman);
        return ResponseEntity.created(URI.create("/tradesmans/create" + tradesmanId.getValue())).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
