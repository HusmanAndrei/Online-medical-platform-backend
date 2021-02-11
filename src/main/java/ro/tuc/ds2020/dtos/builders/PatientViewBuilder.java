package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.view.PatientViewDTO;
import ro.tuc.ds2020.entities.Patient;

public class PatientViewBuilder {

    public static PatientViewDTO generateDTOFromEntity(Patient patient){
        return new PatientViewDTO(
                patient.getId(),
                patient.getName(),
                patient.getBirth_date(),
                patient.getGender(),
                patient.getAddress(),
                patient.getMedicalRecord()
        );
    }

    public static Patient generateEntityFromDTO(PatientViewDTO patientViewDTO){
        return new Patient(
                patientViewDTO.getName(),
                patientViewDTO.getBirthDate(),
                patientViewDTO.getGender(),
                patientViewDTO.getAddress(),
                patientViewDTO.getMedicalRecord()
        );
    }

}
