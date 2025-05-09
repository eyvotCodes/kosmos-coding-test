package com.eyvot.kctapp.domain.contracts;

import com.eyvot.kctapp.model.Cita;

import java.util.List;


public interface CitaServiceContract {

    /**
     * Obtiene un listado de todas las citas del sistema.
     * */
    List<Cita> obtenerCitas();

}
