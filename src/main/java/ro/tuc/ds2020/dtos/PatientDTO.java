package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.MedicalPlan;
//import ro.utcn.onlinemedicationplatform.entities.Caregiver;
//import ro.utcn.onlinemedicationplatform.entities.MedicalPlan;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String birthDate;
    private Character gender;
    private String address;
    private String medicalRecord;
    private Long medicalPlanId;
    private Long caregiverId;
}
