package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.ds2020.entities.util.Type;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
//    private Long id;
//    private String name;
    private String username;
    private String password;
    private Type type;
//    private String birthDate;
//    private Character gender;
//    private String address;
}
