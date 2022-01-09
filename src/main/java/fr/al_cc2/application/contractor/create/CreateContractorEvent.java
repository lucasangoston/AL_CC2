package fr.al_cc2.application.contractor.create;

import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.kernel.ApplicationEvent;

public class CreateContractorEvent implements ApplicationEvent {
    private final ContractorId contractorId;

    public CreateContractorEvent(ContractorId contractorId) {
        this.contractorId = contractorId;
    }
}