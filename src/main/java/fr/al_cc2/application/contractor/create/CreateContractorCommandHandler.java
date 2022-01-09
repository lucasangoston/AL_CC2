package fr.al_cc2.application.contractor.create;

import fr.al_cc2.domain.model.*;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.kernel.command.CommandHandler;
import fr.al_cc2.kernel.event.Event;
import fr.al_cc2.kernel.event.EventDispatcher;

public class CreateContractorCommandHandler implements CommandHandler<CreateContractor, ContractorId> {

    private final ContractorRepository contractorRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateContractorCommandHandler(ContractorRepository contractorRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.eventEventDispatcher = eventEventDispatcher;

    }

    @Override
    public ContractorId handle(CreateContractor createContractor) {
        final ContractorId contractorId = contractorRepository.nextIdentity();
        Contractor contractor = Contractor.of(contractorId, createContractor.firstName, createContractor.lastName, createContractor.mail, createContractor.password, createContractor.service, createContractor.bankingInfos);
        contractorRepository.add(contractor);
        eventEventDispatcher.dispatch(new CreateContractorEvent(contractorId));
        return contractorId;
    }
}
