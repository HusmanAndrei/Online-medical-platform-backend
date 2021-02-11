package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.view.DoctorViewDTO;
import ro.tuc.ds2020.entities.Doctor;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class DoctorViewBuilder {
    public static DoctorViewDTO generateDTOFromEntity(Doctor doctor){
        return new DoctorViewDTO(
                doctor.getId(),
                doctor.getName()
        );
    }

    public static Doctor generateEntityFromDTO(DoctorViewDTO doctorViewDTO){
        return new Doctor(doctorViewDTO.getName());
    }
}
