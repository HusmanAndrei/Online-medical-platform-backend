package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.*;
import ro.tuc.ds2020.dtos.view.DoctorViewDTO;
import ro.tuc.ds2020.dtos.view.MedicationViewDTO;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.services.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")

public class CaregiverController {

    //private final PatientService patientService;
    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) {
        //this.patientService = patientService;
        this.caregiverService = caregiverService;
    }

    @RequestMapping(value = "/patients/{id}", method = RequestMethod.GET)
    public List<PatientDTO> findAllPatientsCaregiver(@PathVariable("id") Long id) { return caregiverService.findAllPatientsCaregiver(id); }

}
