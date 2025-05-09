package com.eyvot.kctapp.domain.contracts;

import com.eyvot.kctapp.model.Consultorio;

import java.util.List;

public interface ConsultorioServiceContract {

    /**
     * Obtiene un listado de todos los consultorios del sistema.
     * */
    List<Consultorio> obtenerConsultorios();

}
