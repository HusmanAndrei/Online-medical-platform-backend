package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;

import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository, PatientRepository patientRepository) {
        this.caregiverRepository = caregiverRepository;
        this.patientRepository = patientRepository;
    }

    public CaregiverDTO findCaregiverById(Long id){
        Optional<Caregiver> caregiver = caregiverRepository.findById(id);
        if(!caregiver.isPresent()){
            throw new ResourceNotFoundException(String.format("not found with %s", id));
        }
        return CaregiverBuilder.generateDTOFromEntity(caregiver.get());
    }

    public List<CaregiverDTO> findAllCaregivers(){
        List<Caregiver> caregivers = caregiverRepository.findAll();
        return caregivers.stream()
                .map(CaregiverBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<PatientDTO> findAllPatientsCaregiver(Long id){
        Optional<Caregiver> caregiverOptional = caregiverRepository.findById(id);

        List<Patient> patients = patientRepository.findAllByCaregiver(caregiverOptional.get());
        return patients.stream()
                .map(PatientBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Long insert(CaregiverDTO caregiverDTO){
        //TODO validation
        return caregiverRepository
                .save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO))
                .getId();
    }
    @Transactional
    public Long update(Long id, CaregiverDTO caregiverDTO){
//        Optional<Caregiver> caregiver = caregiverRepository.findById(id);
//        if(!caregiver.isPresent()){
//            throw new ResourceNotFoundException(String.format("not found with %s", id));
//        }
//        //TODO validator
//        this.caregiverRepository.deleteById(id);
//        return caregiverRepository
//                .save(CaregiverBuilder.generateEntityFromDTO(caregiverDTO))
//                .getId();
        Optional<Caregiver> current = caregiverRepository.findById(id);
        if(!current.isPresent()) {
            return null;
        }
        List<Patient> patientList = current.get().getPatients();
        Caregiver edited = CaregiverBuilder.generateEntityFromDTO(caregiverDTO);
        edited.setPatients(patientList);
        Caregiver c = caregiverRepository.save(edited);
        return c.getId();

    }
    @Transactional
    public void delete(Long id) {
        Caregiver caregiver = caregiverRepository.findById(id).get();
        List<Patient> patients = caregiver.getPatients();
        patients.forEach(p -> p.setCaregiver(null));
        this.caregiverRepository.deleteById(id);
    }

    public Long login(String username, String password){
        Caregiver caregiver = caregiverRepository.findByUsername(username).get();
        if(caregiver != null){
            if(caregiver.getPassword().equals(password)){
                return caregiver.getId();
            }
        }
        return Long.parseLong("-1");
    }
}
