package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.*;
import ro.tuc.ds2020.dtos.view.DoctorViewDTO;
import ro.tuc.ds2020.dtos.view.MedicationViewDTO;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.services.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")

public class PatientController {

    //private final DoctorService doctorService;
    private final PatientService patientService;
    private final CaregiverService caregiverService;
    private final MedicationService medicationService;
    private final MedicalPlanService medicalPlanService;

    private final UserService userService;

    @Autowired
    public PatientController(PatientService patientService, CaregiverService caregiverService, MedicationService medicationService, MedicalPlanService medicalPlanService, UserService userService){
        //this.doctorService = doctorService;
        this.patientService = patientService;
        this.caregiverService = caregiverService;
        this.medicationService = medicationService;
        this.medicalPlanService = medicalPlanService;
        this.userService = userService;

    }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public PatientDTO findPatientById(@PathVariable("id") Long id){
        return patientService.findPatientById(id);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<PatientDTO> findAllPatients() { return patientService.findAllPatients(); }

    @RequestMapping(value = "/caregiver/{id}", method = RequestMethod.GET)
    public CaregiverDTO findCaregiverById(@PathVariable("id") Long id) { return caregiverService.findCaregiverById(id); }

    @RequestMapping(value = "/caregivers", method = RequestMethod.GET)
    public List<CaregiverDTO> findAllCaregivers() { return caregiverService.findAllCaregivers(); }

}
