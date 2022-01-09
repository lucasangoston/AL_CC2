package fr.al_cc2.web.contractor;

import fr.al_cc2.application.contractor.create.CreateContractor;
import fr.al_cc2.application.contractor.retrieve.RetrieveContractors;
import fr.al_cc2.domain.model.Contractor;
import fr.al_cc2.domain.model.ContractorId;
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
public class ContractorController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public ContractorController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/contractors", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ContractorsResponse> getAll() {
        final List<Contractor> contractors = queryBus.send(new RetrieveContractors());
        ContractorsResponse contractorResponseResult = new ContractorsResponse(contractors.stream().map(contractor -> new ContractorResponse(String.valueOf(contractor.getId().getValue()), contractor.getFirstName(), contractor.getLastName(), contractor.getMail(), contractor.getPassword(), contractor.getBankingInfos())).collect(Collectors.toList()));
        return ResponseEntity.ok(contractorResponseResult);
    }

    @PostMapping(path = "/contractors", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid ContractorRequest request) {
        CreateContractor createContractor = new CreateContractor(request.firstname, request.lastname, request.mail, request.password, request.service, request.bankingInfo);
        ContractorId contractorId = commandBus.send(createContractor);
        return ResponseEntity.created(URI.create("/contractors/" + contractorId.getValue())).build();
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
