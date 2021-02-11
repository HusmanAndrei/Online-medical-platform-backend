package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.MedicationViewBuilder;
import ro.tuc.ds2020.dtos.view.MedicationViewDTO;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.repositories.MedicationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository) {
        this.medicationRepository = medicationRepository;
    }

    public MedicationViewDTO findMedicationById(Long id){
        Optional<Medication> medication = medicationRepository.findById(id);
        if(!medication.isPresent()){
            throw new ResourceNotFoundException(String.format("%s not found with %s : '%s'", id));
        }
        return MedicationViewBuilder.generateDTOFromEntity(medication.get());
    }

    public List<MedicationViewDTO> findAllMedications(){
        List<Medication> medications = medicationRepository.findAll();
        return medications.stream()
                .map(MedicationViewBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Long insert(MedicationDTO medicationDTO){
        //TODO validator

        return medicationRepository
                .save(MedicationBuilder.generateEntityFromDTO(medicationDTO))
                .getId();
    }

    public Long update(Long id, MedicationDTO medicationDTO){
        Optional<Medication> medication = medicationRepository.findById(id);
        if(!medication.isPresent()){
            throw new ResourceNotFoundException(String.format("%s not found with %s : '%s'", id));
        }
        this.medicationRepository.deleteById(id);
        //TODO validator
        return medicationRepository
                .save(MedicationBuilder.generateEntityFromDTO(medicationDTO))
                .getId();
    }

    public void delete(Long id) {
        this.medicationRepository.deleteById(id);
    }
}
