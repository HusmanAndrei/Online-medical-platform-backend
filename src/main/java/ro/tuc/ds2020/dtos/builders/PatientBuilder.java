package ro.tuc.ds2020.dtos.builders;

import lombok.NoArgsConstructor;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.MedicalPlan;
import ro.tuc.ds2020.entities.Patient;

@NoArgsConstructor
public class PatientBuilder {

    public static PatientDTO generateDTOFromEntity(Patient patient){
        MedicalPlan medicalPlan = patient.getMedicalPlan();
        Caregiver caregiver = patient.getCaregiver();
        Long mpId = medicalPlan!=null ? medicalPlan.getId() : null;
        Long cId = caregiver!=null ? caregiver.getId() : null;

        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getUsername(),
                patient.getPassword(),
                patient.getBirth_date(),
                patient.getGender(),
                patient.getAddress(),
                patient.getMedicalRecord(),
                mpId,
                cId

        );
    }

    public static Patient generateEntityFromDTO(PatientDTO patientDTO){
        return new Patient(
                patientDTO.getName(),
                patientDTO.getUsername(),
                patientDTO.getPassword(),
                patientDTO.getBirthDate(),
                patientDTO.getGender(),
                patientDTO.getAddress(),
                patientDTO.getMedicalRecord()

        );

    }
}
