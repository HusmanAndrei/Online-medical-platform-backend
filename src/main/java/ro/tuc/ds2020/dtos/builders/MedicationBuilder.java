package ro.tuc.ds2020.dtos.builders;

import lombok.NoArgsConstructor;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.entities.Medication;

@NoArgsConstructor
public class MedicationBuilder {

    public static MedicationDTO generateDTOFromEntity(Medication medication){
        return new MedicationDTO(
                medication.getId(),
                medication.getName(),
                medication.getSideEffects(),
                medication.getDosage()
        );
    }

    public static Medication generateEntityFromDTO(MedicationDTO medicationDTO){
        return new Medication(
                medicationDTO.getName(),
                medicationDTO.getSideEffects(),
                medicationDTO.getDosage()
        );
    }

}

