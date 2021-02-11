package ro.tuc.ds2020.repositories;

import ro.tuc.ds2020.entities.MedicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationHistoryRepository extends JpaRepository<MedicationHistory, Long> {
}

