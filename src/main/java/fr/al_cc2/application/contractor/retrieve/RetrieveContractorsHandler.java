package fr.al_cc2.application.contractor.retrieve;

import fr.al_cc2.domain.model.Contractor;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveContractorsHandler implements QueryHandler<RetrieveContractors, List<Contractor>> {
    private final ContractorRepository contractorRepository;

    public RetrieveContractorsHandler(ContractorRepository contractorRepository) { this.contractorRepository = contractorRepository; }

    @Override
    public List<Contractor> handle(RetrieveContractors query) { return null; }
}
