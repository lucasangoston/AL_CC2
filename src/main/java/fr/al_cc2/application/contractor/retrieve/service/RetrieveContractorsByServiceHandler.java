package fr.al_cc2.application.contractor.retrieve.service;

import fr.al_cc2.domain.model.Contractor;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveContractorsByServiceHandler implements QueryHandler<RetrieveContractorsByService, List<Contractor>> {
    private final ContractorRepository contractorRepository;

    public RetrieveContractorsByServiceHandler(ContractorRepository contractorRepository) { this.contractorRepository = contractorRepository; }

    @Override
    public List<Contractor> handle(RetrieveContractorsByService query) {
        return null;
    }
}
