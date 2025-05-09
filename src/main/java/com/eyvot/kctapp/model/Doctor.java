package com.eyvot.kctapp.model;

import com.eyvot.kctapp.domain.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES, nullable = false)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    @NotBlank
    private String nombre;

    @Column(name = "apellido_paterno", length = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES, nullable = false)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    @NotBlank
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    private String apellidoMaterno;

    @Column(length = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES, nullable = false)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NOMBRES)
    @NotBlank
    private String especialidad;

    @OneToMany(mappedBy = "doctor")
    private List<Cita> citas;


    public Doctor() {}

    public Doctor(Integer id, String nombre, String apellidoPaterno, String apellidoMaterno,
                  String especialidad, List<Cita> citas) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.especialidad = especialidad;
        this.citas = citas;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

}
