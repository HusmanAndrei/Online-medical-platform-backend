package ro.tuc.ds2020.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.util.Type;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User{

    @Column
    private String medicalRecord;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "medical_plan_id", referencedColumnName = "id")
    private MedicalPlan medicalPlan;

    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "caregiver_id", referencedColumnName = "id")
    private Caregiver caregiver;

    public Patient(String name, String birthDate, Character gender, String address, String medicalRecord){
        super(name, birthDate, gender, address);
        this.medicalRecord = medicalRecord;

    }

    public Patient(String name, String username, String password, String birth_date, Character gender, String address, String medicalRecord) {
        super(name, username, password,Type.PATIENT, birth_date, gender, address);
        this.medicalRecord = medicalRecord;
    }

    public Patient(String name, String username, String password, String birthDate, Character gender, String address, String medicalRecord, MedicalPlan medicalPlan, Caregiver caregiver
    ) {
        super(name, username, password, Type.PATIENT, birthDate, gender, address);
        this.medicalRecord = medicalRecord;
        this.medicalPlan = medicalPlan;
        this.caregiver = caregiver;
    }
}
