package com.eyvot.kctapp.domain.contracts;

import com.eyvot.kctapp.model.Cita;

import java.util.List;


public interface CitaServiceContract {

    /**
     * Obtiene un listado de todas las citas del sistema.
     * */
    List<Cita> obtenerCitas();

    /**
     * Agenda una nueva cita en el sistema.
     *
     * Reglas de negocio:
     * No se puede agendar cita en un mismo consultorio a la misma hora.
     * No se puede agendar cita para un mismo Dr. a la misma hora.
     * No se puede agendar cita para un paciente a la una misma hora ni con menos de 2 horas de diferencia para el mismo día.
     * Un mismo doctor no puede tener más de 8 citas en el día.
     *
     * Se retornará un mensaje de error en caso de no cumplir con alguna de las reglas de negocio.
     * Si la operación es exitosa se retorna null.
     * */
    String agendarCita(Cita nuevaCita);

}
