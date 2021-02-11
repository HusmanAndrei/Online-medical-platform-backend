package ro.tuc.ds2020.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medication_history")
public class MedicationHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "medication_plan_id")
    private Long medicationPlanId;

    @Column(name = "medication_name")
    private String medicationName;

    private LocalDateTime time;

    @Type(type="yes_no")
    private boolean taken;
}
