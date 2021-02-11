package ro.tuc.ds2020.services;

import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.MedicalPlanDTO;
import ro.tuc.ds2020.dtos.builders.MedicalPlanBuilder;
import ro.tuc.ds2020.entities.MedicalPlan;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.repositories.MedicalPlanRepository;

import java.util.Optional;

@Service
public class MedicalPlanService {

    private final MedicalPlanRepository medicalPlanRepository;

    public MedicalPlanService(MedicalPlanRepository medicalPlanRepository) {
        this.medicalPlanRepository = medicalPlanRepository;
    }

    public MedicalPlanDTO findMedicalPlanByPatient(Patient patient){
        Optional<MedicalPlan> medicalPlan = medicalPlanRepository.findByPatient(patient);
        if(!medicalPlan.isPresent()){
            throw new ResourceNotFoundException(String.format("%s not found with %s : '%s'", patient));
        }
        return new MedicalPlanBuilder().generateDTOFromEntity(medicalPlan.get());
    }

    public Long insertMedicalPlan (MedicalPlanDTO medicalPlanDTO){
        return medicalPlanRepository
                .save(MedicalPlanBuilder.generateEntityFromDTO(medicalPlanDTO))
                .getId();
    }
}

