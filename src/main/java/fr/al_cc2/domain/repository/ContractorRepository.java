package fr.al_cc2.domain.repository;

import fr.al_cc2.domain.model.Contractor;
import fr.al_cc2.domain.model.ContractorId;
import fr.al_cc2.kernel.Repository;

import java.util.List;

public interface ContractorRepository extends Repository<ContractorId, Contractor> {
    List<Contractor> findAll();

    List<Contractor> findByService(String service);
}
