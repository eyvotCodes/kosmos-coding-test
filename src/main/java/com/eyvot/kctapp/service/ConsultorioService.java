package com.eyvot.kctapp.service;

import com.eyvot.kctapp.domain.contracts.ConsultorioServiceContract;
import com.eyvot.kctapp.model.Consultorio;
import com.eyvot.kctapp.repository.ConsultorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ConsultorioService implements ConsultorioServiceContract {

    private final ConsultorioRepository consultorioRepository;


    public ConsultorioService(ConsultorioRepository consultorioRepository) {
        this.consultorioRepository = consultorioRepository;
    }


    @Override
    public List<Consultorio> obtenerConsultorios() {
        return consultorioRepository.findAll();
    }

}
