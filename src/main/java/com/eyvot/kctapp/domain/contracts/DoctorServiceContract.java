package com.eyvot.kctapp.domain.contracts;

import com.eyvot.kctapp.model.Doctor;

import java.util.List;


public interface DoctorServiceContract {

    /**
     * Obtiene un listado de todos los doctores del sistema.
     * */
    List<Doctor> obtenerDoctores();

}
