package fr.al_cc2.infrastructure;

import fr.al_cc2.domain.model.Contractor;
import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.domain.repository.ContractorRepository;
import fr.al_cc2.kernel.exception.NoSuchEntityException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryContractorRepository implements ContractorRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<ContractorId, Contractor> data = new ConcurrentHashMap<>();

    @Override
    public List<Contractor> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public List<Contractor> findByService(String service) {
        return List.copyOf(data.values().stream()
                .filter(contractor -> contractor.getService().equals(service)).collect(Collectors.toList()));
    }

    @Override
    public ContractorId nextIdentity() {
        return new ContractorId(count.incrementAndGet());
    }

    @Override
    public Contractor findById(ContractorId id) throws NoSuchEntityException {
        final Contractor contractor = data.get(id);
        if (contractor == null) {
            throw NoSuchEntityException.withContractorId(id);
        }
        return contractor;
    }

    @Override
    public void add(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }

    @Override
    public void delete(ContractorId id) {
        data.remove(id);
    }
}
