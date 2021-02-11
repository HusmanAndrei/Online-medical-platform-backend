package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.dtos.MedicalPlanDTO;
import ro.tuc.ds2020.entities.MedicalPlan;
import ro.tuc.ds2020.entities.Patient;

import java.util.Optional;

@Repository
public interface MedicalPlanRepository extends JpaRepository<MedicalPlan, Long> {

    Optional<MedicalPlan> findByPatient(Patient patient);

}

