package ro.tuc.ds2020.dtos.builders;

import lombok.NoArgsConstructor;
import ro.tuc.ds2020.dtos.view.MedicationViewDTO;
import ro.tuc.ds2020.entities.Medication;

@NoArgsConstructor
public class MedicationViewBuilder {

    public static MedicationViewDTO generateDTOFromEntity(Medication medication){
        return new MedicationViewDTO(
                medication.getId(),
                medication.getName(),
                medication.getSideEffects(),
                medication.getDosage()
        );
    }

    public static Medication generateEntityFromDTO(MedicationViewDTO medicationViewDTO){
        return new Medication(
                medicationViewDTO.getName(),
                medicationViewDTO.getSideEffects(),
                medicationViewDTO.getDosage()
        );
    }

}

