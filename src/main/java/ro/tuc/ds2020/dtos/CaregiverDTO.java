package ro.tuc.ds2020.dtos;


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
public class CaregiverDTO {
    private Long id;
    private String name;
    private String birthDate;
    private Character gender;
    private String username;
    private String password;
    private String address;

}

