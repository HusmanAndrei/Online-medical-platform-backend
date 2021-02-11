package ro.tuc.ds2020.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicationViewDTO {

    private Long id;
    private String name;
    private String sideEffects;
    private String dosage;

}
