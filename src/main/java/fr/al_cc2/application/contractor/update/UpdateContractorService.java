package fr.al_cc2.application.contractor.update;

import fr.al_cc2.kernel.command.Command;

public class UpdateContractorService implements Command {

    public final int contractorId;
    public final String service;

    public UpdateContractorService(int contractorId, String service) {
        this.contractorId = contractorId;
        this.service = service;
    }
}
