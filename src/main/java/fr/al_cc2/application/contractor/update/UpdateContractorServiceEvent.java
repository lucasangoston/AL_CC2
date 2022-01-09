package fr.al_cc2.application.contractor.update;

import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.kernel.ApplicationEvent;

public class UpdateContractorServiceEvent implements ApplicationEvent {
    private final ContractorId contractorId;

    public UpdateContractorServiceEvent(ContractorId contractorId) {
        this.contractorId = contractorId;
    }
}