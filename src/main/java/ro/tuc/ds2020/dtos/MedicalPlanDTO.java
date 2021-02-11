package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalPlanDTO {

    private Long id;
    private String name;
    private String instructions;
    private String treatmentPeriod;
    private List<Medication> medications;
    private Patient patient;

}
