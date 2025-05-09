package com.eyvot.kctapp.model;

import com.eyvot.kctapp.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "horario_inicio", nullable = false)
    @NotNull
    private LocalDateTime horarioInicio;

    @Column(name = "horario_fin", nullable = false)
    @NotNull
    private LocalDateTime horarioFin;

    @Column(name = "nombre_paciente", length = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES, nullable = false)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    @NotBlank
    private String nombrePaciente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    @NotNull
    private Doctor doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "consultorio_id")
    @NotNull
    private Consultorio consultorio;


    public Cita() {}

    public Cita(Integer id, LocalDateTime horarioInicio, LocalDateTime horarioFin, String nombrePaciente,
                Doctor doctor, Consultorio consultorio) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.nombrePaciente = nombrePaciente;
        this.doctor = doctor;
        this.consultorio = consultorio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDateTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDateTime getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(LocalDateTime horarioFin) {
        this.horarioFin = horarioFin;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

}
