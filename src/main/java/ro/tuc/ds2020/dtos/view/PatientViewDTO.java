package ro.tuc.ds2020.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientViewDTO {
    private Long id;
    private String name;
    private String birthDate;
    private Character gender;
    private String address;
    private String medicalRecord;
}