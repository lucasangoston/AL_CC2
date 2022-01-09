package fr.al_cc2.application.contractor.update;

import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.kernel.command.CommandHandler;
import fr.al_cc2.kernel.event.Event;
import fr.al_cc2.kernel.event.EventDispatcher;

public class UpdateContractorServiceCommandHandler implements CommandHandler<UpdateContractorService, Void> {
    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public UpdateContractorServiceCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public Void handle(UpdateContractorService command) {
        var contractorId = new ContractorId(command.contractorId);
        var contractor = contractorRepository.findById(contractorId);
        //var address = new Address(command.address.city);
        //user.changeAddress(address);
        contractorRepository.add(contractor);
        eventEventDispatcher.dispatch(new UpdateContractorServiceEvent(contractorId));
        return null;
    }
}
