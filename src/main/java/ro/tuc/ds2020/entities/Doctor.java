package ro.tuc.ds2020.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.util.Type;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Doctor extends User{

    public Doctor(String name){
        super(name, Type.DOCTOR);
    }

    public Doctor(String name, String username, String password, String birthDate, Character gender, String address) {
        super(name, username, password, Type.DOCTOR, birthDate, gender, address);
    }

}
