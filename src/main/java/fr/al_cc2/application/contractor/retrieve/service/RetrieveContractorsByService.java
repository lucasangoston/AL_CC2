package fr.al_cc2.application.contractor.retrieve.service;

import fr.al_cc2.kernel.query.Query;

public class RetrieveContractorsByService implements Query {
    public final String service;

    public RetrieveContractorsByService(String service) { this.service = service; }
}
