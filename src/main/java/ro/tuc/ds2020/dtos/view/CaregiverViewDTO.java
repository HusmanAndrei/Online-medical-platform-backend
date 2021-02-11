package ro.tuc.ds2020.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.Patient;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaregiverViewDTO {
    private Long id;
    private String name;
    private List<Patient> patients;
}

