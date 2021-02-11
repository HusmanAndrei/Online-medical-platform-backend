package ro.tuc.ds2020.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.util.Type;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Caregiver extends User {

    @OneToMany(mappedBy = "caregiver", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Patient> patients = new ArrayList<>();

    public Caregiver(String name, List<Patient> patients){
        super(name, Type.CAREGIVER);
        this.patients = patients;
    }

    public Caregiver(String name, String username, String password, String birthDate, Character gender, String address, List<Patient> patients) {
        super(name, username, password, Type.CAREGIVER, birthDate, gender, address);
        this.patients = patients;
    }

    public Caregiver(Long id, String name, String username, String password, String birth_date, Character gender, String address) {
        super(id, name, username, password, Type.CAREGIVER, birth_date, gender, address);
    }
}


