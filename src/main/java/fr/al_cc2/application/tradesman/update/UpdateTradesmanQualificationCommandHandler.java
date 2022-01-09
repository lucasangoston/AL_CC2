package fr.al_cc2.application.tradesman.update;

import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.kernel.command.CommandHandler;
import fr.al_cc2.kernel.event.Event;
import fr.al_cc2.kernel.event.EventDispatcher;

public class UpdateTradesmanQualificationCommandHandler implements CommandHandler<UpdateTradesmanQualification, Void> {
    private final TradesmanRepository tradesmanRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public UpdateTradesmanQualificationCommandHandler(TradesmanRepository tradesmanRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }


    @Override
    public Void handle(UpdateTradesmanQualification command) {
        var trandesmanId = new TradesmanId(command.tradesmanId);
        var tradesman = tradesmanRepository.findById(trandesmanId);
        //var address = new Address(command.address.city);
        //user.changeAddress(address);
        tradesmanRepository.add(tradesman);
        eventEventDispatcher.dispatch(new UpdateTrandesmanQualificationEvent(trandesmanId));
        return null;
    }
}
