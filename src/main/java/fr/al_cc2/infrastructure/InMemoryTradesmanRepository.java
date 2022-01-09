package fr.al_cc2.infrastructure;

import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.domain.repository.TradesmanRepository;
import fr.al_cc2.kernel.exception.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger count = new AtomicInteger(0);
    private final Map<TradesmanId, Tradesman> data = new ConcurrentHashMap<>();

    @Override
    public List<Tradesman> findAll() { return List.copyOf(data.values()); }

    @Override
    public List<Tradesman> findByQualification(String qualification) {
        return List.copyOf(data.values().stream()
                .filter(tradesman -> tradesman.getQualification().equals(qualification)).collect(Collectors.toList()));
    }

    @Override
    public TradesmanId nextIdentity() {
        return new TradesmanId(count.incrementAndGet());
    }

    @Override
    public Tradesman findById(TradesmanId id) throws NoSuchEntityException {
        final Tradesman tradesman = data.get(id);
        if (tradesman == null) {
            throw NoSuchEntityException.withTradesmanId(id);
        }
        return tradesman;
    }

    @Override
    public void add(Tradesman tradesman) { data.put(tradesman.getId(), tradesman); }

    @Override
    public void delete(TradesmanId id) { data.remove(id); }
}
