package fr.al_cc2.application.tradesman.create;

import fr.al_cc2.domain.model.Certificates;
import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.kernel.command.CommandHandler;
import fr.al_cc2.kernel.event.Event;
import fr.al_cc2.kernel.event.EventDispatcher;

public class CreateTradesmanCommandHandler implements CommandHandler<CreateTradesman, TradesmanId> {

    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateTradesmanCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventEventDispatcher = eventEventDispatcher;

    }

    @Override
    public TradesmanId handle(CreateTradesman createTradesman) {
        final TradesmanId tradesmanId = tradesmanRepository.nextIdentity();
        Tradesman tradesman = Tradesman.of(tradesmanId, createTradesman.firstName, createTradesman.lastName, createTradesman.mail, createTradesman.password, createTradesman.qualification, createTradesman.skills, createTradesman.geographicalArea, createTradesman.dailyRate, createTradesman.bankingInfo, new Certificates(createTradesman.certificates.getName(), createTradesman.certificates.getDate()));
        tradesmanRepository.add(tradesman);
        eventEventDispatcher.dispatch(new CreateTradesmanEvent(tradesmanId));
        return tradesmanId;
    }
}
