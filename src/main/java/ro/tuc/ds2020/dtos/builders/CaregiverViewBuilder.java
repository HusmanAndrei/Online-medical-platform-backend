package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.view.CaregiverViewDTO;
import ro.tuc.ds2020.entities.Caregiver;

public class CaregiverViewBuilder {

    public static CaregiverViewDTO generateDTOFromEntity(Caregiver caregiver){
        return new CaregiverViewDTO(
                caregiver.getId(),
                caregiver.getName(),
                caregiver.getPatients()
        );
    }

    public static Caregiver generateEntityFromDTO(CaregiverViewDTO caregiverViewDTO){
        return new Caregiver(
                caregiverViewDTO.getName(),
                caregiverViewDTO.getPatients()
        );
    }
}
