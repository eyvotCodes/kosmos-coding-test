package com.eyvot.kctapp.service;

import com.eyvot.kctapp.domain.contracts.DoctorServiceContract;
import com.eyvot.kctapp.model.Doctor;
import com.eyvot.kctapp.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService implements DoctorServiceContract {

    private final DoctorRepository doctorRepository;


    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    @Override
    public List<Doctor> obtenerDoctores() {
        return doctorRepository.findAll();
    }

}
