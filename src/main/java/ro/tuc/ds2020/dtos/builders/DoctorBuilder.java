package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.entities.Doctor;

public class DoctorBuilder {

    public static DoctorDTO generateDTOFromEntity(Doctor doctor){
        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getUsername(),
                doctor.getPassword(),
                doctor.getBirth_date(),
                doctor.getGender(),
                doctor.getAddress()
        );
    }

    public static Doctor generateEntityFromDTO(DoctorDTO doctorDTO){
        return new Doctor(
                doctorDTO.getName(),
                doctorDTO.getUsername(),
                doctorDTO.getPassword(),
                doctorDTO.getBirthDate(),
                doctorDTO.getGender(),
                doctorDTO.getAddress()
        );
    }

}
