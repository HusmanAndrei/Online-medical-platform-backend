package ro.tuc.ds2020.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ro.tuc.ds2020.entities.util.Type;

import javax.persistence.*;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {
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
    private String username;

    @Column
    private String password;

    @Column
    private Type type;

    @Column
    private String birth_date;

    @Column
    private Character gender;

    @Column
    private String address;

    public User(String name, Type type){
        this.name = name;
        this.type = type;
    }

    public User(String name, String birth_date, Character gender, String address){
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
    }

    public User(String name, String username, String password, Type type, String birth_date, Character gender, String address) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
    }

    public Long getId() {
        return id;
    }
}



