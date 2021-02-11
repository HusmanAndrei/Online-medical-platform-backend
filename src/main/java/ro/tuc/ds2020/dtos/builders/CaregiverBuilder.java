package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.entities.Caregiver;

public class CaregiverBuilder {

    public static CaregiverDTO generateDTOFromEntity(Caregiver caregiver){
        return new CaregiverDTO(
                caregiver.getId(),
                caregiver.getName(),
                caregiver.getBirth_date(),
                caregiver.getGender(),
                caregiver.getUsername(),
                caregiver.getPassword(),
                caregiver.getAddress()
        );
    }

    public static Caregiver generateEntityFromDTO(CaregiverDTO caregiverDTO){
        Long id = caregiverDTO.getId();
        return new Caregiver(
                caregiverDTO.getId(),
                caregiverDTO.getName(),
                caregiverDTO.getUsername(),
                caregiverDTO.getPassword(),
                caregiverDTO.getBirthDate(),
                caregiverDTO.getGender(),
                caregiverDTO.getAddress()
        );
    }

}

