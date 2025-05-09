package com.eyvot.kctapp.service;

import com.eyvot.kctapp.domain.config.Constants;
import com.eyvot.kctapp.domain.contracts.CitaServiceContract;
import com.eyvot.kctapp.model.Cita;
import com.eyvot.kctapp.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public String agendarCita(Cita nuevaCita) {
        LocalDateTime horarioInicialDelDia = nuevaCita.getHorarioInicio().toLocalDate().atStartOfDay();
        LocalDateTime horarioFinalDelDia = horarioInicialDelDia.plusDays(1).minusSeconds(1);
        LocalDateTime horarioInicioCita = nuevaCita.getHorarioInicio();
        LocalDateTime horarioFinalCita = nuevaCita.getHorarioFin();

        // evaluar: doctor o consultorio ocupados
        var conflictosHorario = citaRepository.buscarConflictosDeHorario(
                horarioInicioCita, horarioFinalCita, horarioInicialDelDia, horarioFinalDelDia,
                nuevaCita.getConsultorio().getId(),
                nuevaCita.getDoctor().getId()
        );
        if (!conflictosHorario.isEmpty()) {
            return Constants.MENSAJE_ERROR_CONFLICTO_HORARIOS;
        }

        // evaluar: paciente con traslape o muy cercano
        LocalDateTime rangoInferior = horarioInicioCita.minusHours(Constants.NUMERO_MINIMO_HORAS_ENTRE_CONSULTAS_DE_PACIENTE);
        LocalDateTime rangoSuperior = horarioFinalCita.plusHours(Constants.NUMERO_MINIMO_HORAS_ENTRE_CONSULTAS_DE_PACIENTE);
        var conflictosPaciente = citaRepository.buscarCitasParaPacienteEnTimpoNoPermitido(
                nuevaCita.getNombrePaciente(), rangoInferior, rangoSuperior, horarioInicialDelDia, horarioFinalDelDia
        );
        if (!conflictosPaciente.isEmpty()) {
            return Constants.MENSAJE_ERROR_PACIENTE_CON_CITAS_CERCANAS;
        }

        // evaluar: doctor con más de 8 citas
        int totalCitasDoctor = citaRepository.contarCitasDeDoctorEnElMismoDia(
                nuevaCita.getDoctor().getId(), horarioInicialDelDia, horarioFinalDelDia
        );
        if (totalCitasDoctor >= Constants.NUMER_MAXIMO_CITAS_DOCTOR_PERMITIDAS_EL_MISMO_DIA) {
            return Constants.MENSAJE_ERROR_DOCTOR_CON_MAXIMO_DE_CITAS_PERMITIDAS;
        }

        citaRepository.save(nuevaCita);
        return null;
    }

}
