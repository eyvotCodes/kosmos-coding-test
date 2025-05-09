package com.eyvot.kctapp.repository;

import com.eyvot.kctapp.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query("""
        SELECT c FROM Cita c
        WHERE c.horarioInicio < :horarioFin
          AND c.horarioFin > :horarioInicio
          AND c.horarioInicio BETWEEN :inicioDia AND :finDia
          AND (
              c.consultorio.id = :consultorioId
              OR c.doctor.id = :doctorId
          )
    """)
    List<Cita> buscarConflictosDeHorario(
            @Param("horarioInicio") LocalDateTime horarioInicio,
            @Param("horarioFin") LocalDateTime horarioFin,
            @Param("inicioDia") LocalDateTime inicioDia,
            @Param("finDia") LocalDateTime finDia,
            @Param("consultorioId") Integer consultorioId,
            @Param("doctorId") Integer doctorId
    );

    @Query("""
    SELECT c FROM Cita c
    WHERE c.nombrePaciente = :nombrePaciente
      AND c.horarioInicio < :limiteSuperior
      AND c.horarioFin > :limiteInferior
      AND c.horarioInicio BETWEEN :inicioDia AND :finDia
    """)
    List<Cita> buscarCitasParaPacienteEnTimpoNoPermitido(
            @Param("nombrePaciente") String nombrePaciente,
            @Param("limiteInferior") LocalDateTime limiteInferior,
            @Param("limiteSuperior") LocalDateTime limiteSuperior,
            @Param("inicioDia") LocalDateTime inicioDia,
            @Param("finDia") LocalDateTime finDia
    );

    @Query("""
        SELECT COUNT(c) FROM Cita c
        WHERE c.doctor.id = :doctorId
          AND c.horarioInicio BETWEEN :inicioDia AND :finDia
    """)
    int contarCitasDeDoctorEnElMismoDia(
            @Param("doctorId") Integer doctorId,
            @Param("inicioDia") LocalDateTime inicioDia,
            @Param("finDia") LocalDateTime finDia
    );

}
