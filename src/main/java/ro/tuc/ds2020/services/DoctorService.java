package ro.tuc.ds2020.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.builders.DoctorBuilder;
import ro.tuc.ds2020.dtos.builders.DoctorViewBuilder;
import ro.tuc.ds2020.dtos.view.DoctorViewDTO;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.repositories.DoctorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public DoctorViewDTO findDoctorById(Long id){
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if(!doctor.isPresent()){
            throw new ResourceNotFoundException("Doctor");
        }
        return DoctorViewBuilder.generateDTOFromEntity(doctor.get());
    }


    public List<DoctorViewDTO> findAll() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(DoctorViewBuilder::generateDTOFromEntity).collect(Collectors.toList());
    }


    public Long insert(DoctorDTO doctorDTO){
        return doctorRepository.save(DoctorBuilder.generateEntityFromDTO(doctorDTO)).getId();
    }


}
