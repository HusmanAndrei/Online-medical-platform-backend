package ro.tuc.ds2020.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicalPlan {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private Long id;

    @Column
    private String name;

    @Column
    private String instructions;

    @Column
    private String treatmentPeriod;

    @OneToOne(mappedBy = "medicalPlan")
    private Patient patient;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.DETACH})
    @JoinTable(name = "medical_plan_medication",
            joinColumns = @JoinColumn(name = "medical_plan_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id", referencedColumnName = "id"))
    private List<Medication> medications = new ArrayList<>();

    public MedicalPlan(String name, String instructions, String treatmentPeriod, Patient patient, List<Medication> medications) {
        this.name = name;
        this.instructions = instructions;
        this.treatmentPeriod = treatmentPeriod;
        this.patient = patient;
        this.medications = medications;
    }
}

