package fr.al_cc2.application.tradesman.retrieve;

import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.kernel.query.QueryHandler;

import java.util.List;

public class RetrieveTradesmansHandler implements QueryHandler<RetrieveTradesmans, List<Tradesman>> {
    private final TradesmanRepository tradesmanRepository;

    public RetrieveTradesmansHandler(TradesmanRepository tradesmanRepository) { this.tradesmanRepository = tradesmanRepository; }

    @Override
    public List<Tradesman> handle(RetrieveTradesmans query) {
        return null;
    }
}
