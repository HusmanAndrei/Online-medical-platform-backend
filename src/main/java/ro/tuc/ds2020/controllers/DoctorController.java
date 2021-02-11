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
@RequestMapping(value = "/doctor")

public class DoctorController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final CaregiverService caregiverService;
    private final MedicationService medicationService;
    private final MedicalPlanService medicalPlanService;

    private final UserService userService;

    @Autowired
    public DoctorController(DoctorService doctorService, PatientService patientService, CaregiverService caregiverService, MedicationService medicationService, MedicalPlanService medicalPlanService, UserService userService){
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.caregiverService = caregiverService;
        this.medicationService = medicationService;
        this.medicalPlanService = medicalPlanService;
        this.userService = userService;

    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public DoctorViewDTO findById(@PathVariable("id") Long id){
        return doctorService.findDoctorById(id);
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<DoctorViewDTO> findAll(){
        return doctorService.findAll();
    }

    @RequestMapping(value="/insert", method = RequestMethod.POST)
    public Long insert(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.insert(doctorDTO);
    }


    /***********************
     * CRUD on patients
     ***********************/

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
    public PatientDTO findPatientById(@PathVariable("id") Long id){
        return patientService.findPatientById(id);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<PatientDTO> findAllPatients() { return patientService.findAllPatients(); }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public Long insertPatient(@RequestBody PatientDTO patientDTO) { return patientService.save(patientDTO).getId(); }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.PUT)
    public Long updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO patientDTO) { return patientService.update(id, patientDTO); }

    @RequestMapping(value = "/patient/{id}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") Long id) { patientService.delete(id); }

    @RequestMapping(value = "/caregiver/{id}", method = RequestMethod.GET)
    public CaregiverDTO findCaregiverById(@PathVariable("id") Long id) { return caregiverService.findCaregiverById(id); }

    @RequestMapping(value = "/caregivers", method = RequestMethod.GET)
    public List<CaregiverDTO> findAllCaregivers() { return caregiverService.findAllCaregivers(); }

    @RequestMapping(value = "/caregiver", method = RequestMethod.POST)
    public Long insertCaregiver(@RequestBody CaregiverDTO caregiverDTO) { return caregiverService.insert(caregiverDTO); }

    @RequestMapping(value = "/caregiver/{id}", method = RequestMethod.PUT)
    public Long updateCaregiver(@PathVariable("id") Long id, @RequestBody CaregiverDTO caregiverDTO) { return caregiverService.update(id, caregiverDTO); }

    @RequestMapping(value = "/caregiver/{id}", method = RequestMethod.DELETE)
    public Long deleteCaregiver(@PathVariable("id") Long id) { caregiverService.delete(id); return id; }



    @PostMapping("login")
    public User login(@Valid @RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO.getUsername(), loginDTO.getPassword());
    }


//    @PostMapping("login")
//    public User login(@Valid @RequestBody final DoctorDTO doctorLoginRequestDTO) {
//        return userService.login(doctorLoginRequestDTO);
//    }
//
//    @PostMapping("login")
//    public User login(@Valid @RequestBody final CaregiverDTO caregiverLoginRequestDTO) {
//        return userService.login(caregiverLoginRequestDTO);
//    }


    /***********************
     * CRUD on medication
     ***********************/

    @RequestMapping(value = "/medication/{id}", method = RequestMethod.GET)
    public MedicationViewDTO findMedicationById(@PathVariable("id") Long id) { return medicationService.findMedicationById(id); }

    @RequestMapping(value = "/medications", method = RequestMethod.GET)
    public List<MedicationViewDTO> findAllMedications() { return medicationService.findAllMedications(); }

    @RequestMapping(value = "/medication", method = RequestMethod.POST)
    public Long insertMedication(@RequestBody MedicationDTO medicationDTO) { return medicationService.insert(medicationDTO); }

    @RequestMapping(value = "/medication/{id}", method = RequestMethod.PUT)
    public Long updateMedication(@PathVariable("id") Long id, @RequestBody MedicationDTO medicationDTO) { return medicationService.update(id, medicationDTO); }

    @RequestMapping(value = "/medication/{id}", method = RequestMethod.DELETE)
    public void deleteMedication(@PathVariable("id") Long id) { medicationService.delete(id); }

    /***********************
     * Create Medical Plan
     ***********************/

    @RequestMapping(value = "/createMedicalPlan", method = RequestMethod.POST)
    public Long createMedicalPlan(@RequestBody MedicalPlanDTO medicalPlanDTO) { return medicalPlanService.insertMedicalPlan(medicalPlanDTO); }
}
