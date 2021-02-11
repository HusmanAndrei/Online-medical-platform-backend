package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class PatientService {

    private  final PatientRepository patientRepository;
    private final CaregiverRepository caregiverRepository;


    @Autowired
    public PatientService(PatientRepository patientRepository, CaregiverRepository caregiverRepository) {
        this.patientRepository = patientRepository;
        this.caregiverRepository = caregiverRepository;

    }

    public PatientDTO findPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if(!patient.isPresent()){
            throw new ResourceNotFoundException(String.format("%s not found with %s : '%s'", id));
        }
        return PatientBuilder.generateDTOFromEntity(patient.get());
    }

    public List<PatientDTO> findAllPatients(){
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Long insert(PatientDTO patientDTO){
        //TODO validator
        return patientRepository
                .save(PatientBuilder.generateEntityFromDTO(patientDTO))
                .getId();
    }
    @Transactional
    public Patient save(PatientDTO patientDto) {
        Patient patient = PatientBuilder.generateEntityFromDTO(patientDto);
        Optional<Caregiver> caregiverOptional;

        if (nonNull(patientDto.getCaregiverId())) {
            caregiverOptional = caregiverRepository.findById(patientDto.getCaregiverId());
            caregiverOptional.ifPresent(patient::setCaregiver);
            if (patient.getCaregiver() == null) {
                throw new ResourceNotFoundException("Caregiver");
            }
        }

        return patientRepository.save(patient);
    }
    @Transactional
    public Long update(Long id, PatientDTO patientDTO){
        Optional<Patient> doctor = patientRepository.findById(id);
        if(!doctor.isPresent()){
            throw new ResourceNotFoundException(String.format("%s not found with %s : '%s'", patientDTO.getId()));
        }
        this.patientRepository.deleteById(id);
        //TODO validator
        Patient edited = PatientBuilder.generateEntityFromDTO(patientDTO);
        Long caregiverId = patientDTO.getCaregiverId();
        Optional<Caregiver> caregiver = caregiverRepository.findById(caregiverId);
        Caregiver actualCaregiver = null;
        if (caregiver.isPresent()){
            actualCaregiver = caregiver.get();
        }
        edited.setCaregiver(actualCaregiver);
        return patientRepository
                .save(edited)
                .getId();
    }

    public void delete(Long id) {
        this.patientRepository.deleteById(id);
    }
}
