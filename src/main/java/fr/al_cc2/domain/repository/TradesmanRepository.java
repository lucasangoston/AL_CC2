package fr.al_cc2.domain.repository;

import fr.al_cc2.domain.model.Tradesman;
import fr.al_cc2.domain.model.TradesmanId;
import fr.al_cc2.kernel.Repository;

import java.util.List;

public interface TradesmanRepository extends Repository<TradesmanId, Tradesman> {
    List<Tradesman> findAll();

    List<Tradesman> findByQualification(String qualification);
}
