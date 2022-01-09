package fr.al_cc2.application.tradesman.retrieve.qualification;

import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveTradesmansByQualificationHandler implements QueryHandler<RetrieveTradesmansByQualification, List<Tradesman>> {
    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmansByQualificationHandler(TradesmanRepository tradesmanRepository) { this.tradesmanRepository = tradesmanRepository; }

    @Override
    public List<Tradesman> handle(RetrieveTradesmansByQualification query) {
        return null;
    }
}
