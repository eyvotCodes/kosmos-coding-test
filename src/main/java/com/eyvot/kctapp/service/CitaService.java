package com.eyvot.kctapp.service;

import com.eyvot.kctapp.domain.contracts.CitaServiceContract;
import com.eyvot.kctapp.model.Cita;
import com.eyvot.kctapp.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CitaService implements CitaServiceContract {

    private final CitaRepository citaRepository;


    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }


    @Override
    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

}
