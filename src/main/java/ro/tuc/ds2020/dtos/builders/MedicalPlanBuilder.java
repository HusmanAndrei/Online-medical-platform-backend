package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.MedicalPlanDTO;
import ro.tuc.ds2020.entities.MedicalPlan;

import java.util.stream.Collectors;

public class MedicalPlanBuilder {

    public static MedicalPlanDTO generateDTOFromEntity(MedicalPlan medicalPlan){
        return new MedicalPlanDTO(
                medicalPlan.getId(),
                medicalPlan.getName(),
                medicalPlan.getInstructions(),
                medicalPlan.getTreatmentPeriod(),
                medicalPlan.getMedications(),
                medicalPlan.getPatient()
        );
    }

    public static MedicalPlan generateEntityFromDTO(MedicalPlanDTO medicalPlanDTO){
        return new MedicalPlan(
                medicalPlanDTO.getName(),
                medicalPlanDTO.getInstructions(),
                medicalPlanDTO.getTreatmentPeriod(),
                medicalPlanDTO.getPatient(),
                medicalPlanDTO.getMedications()
        );
    }

}

