package ro.tuc.ds2020.services;

import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.DoctorRepository;
import ro.tuc.ds2020.repositories.PatientRepository;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.Optional;

@Service
public final class UserService {

    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final CaregiverRepository caregiverRepository;


    public UserService(UserRepository userRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, CaregiverRepository caregiverRepository) {
        this.userRepository = userRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.caregiverRepository = caregiverRepository;

    }

//    public User login(final UserDTO userLoginRequestDto) {
//        final Optional<User> userOptional = userRepository
//                .findByUsername(userLoginRequestDto.getUsername())
//                .filter(user -> userLoginRequestDto.getPassword().equals(user.getPassword()));
//
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        } else {
//            throw new ResourceNotFoundException("alabala");
//        }
//    }


    public Patient login(final PatientDTO patientLoginRequestDTO) {
        final Optional<Patient> patientOptional = patientRepository
                .findByUsername(patientLoginRequestDTO.getUsername())
                .filter(user -> patientLoginRequestDTO.getPassword().equals(user.getPassword()));

        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            throw new ResourceNotFoundException("alabala");
        }
    }


    public Doctor login(final DoctorDTO doctorLoginRequestDTO) {
        final Optional<Doctor> doctorOptional = doctorRepository
                .findByUsername(doctorLoginRequestDTO.getUsername())
                .filter(user -> doctorLoginRequestDTO.getPassword().equals(user.getPassword()));

        if (doctorOptional.isPresent()) {
        return doctorOptional.get();
        } else {
            throw new ResourceNotFoundException("alabala");
        }
    }

    public Caregiver login(final CaregiverDTO caregiverLoginRequestDTO) {
        final Optional<Caregiver> caregiverOptional = caregiverRepository
                .findByUsername(caregiverLoginRequestDTO.getUsername())
                .filter(user -> caregiverLoginRequestDTO.getPassword().equals(user.getPassword()));

        if (caregiverOptional.isPresent()) {
        return caregiverOptional.get();
        } else {
            throw new ResourceNotFoundException("alabala");
        }
    }

    public User login(final String username, final String password) {
        final Optional<Caregiver> caregiverOptional = caregiverRepository
                .findByUsername(username)
                .filter(user -> password.equals(user.getPassword()));
        final Optional<Doctor> doctorOptional = doctorRepository
                .findByUsername(username)
                .filter(user -> password.equals(user.getPassword()));
        final Optional<Patient> patientOptional = patientRepository
                .findByUsername(username)
                .filter(user -> password.equals(user.getPassword()));

        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else if (caregiverOptional.isPresent()){
            return caregiverOptional.get();
        } else if (doctorOptional.isPresent()) {
            return doctorOptional.get();
        } else {
            throw new ResourceNotFoundException("alabala");
        }
    }

}
