package com.eyvot.kctapp.model;

import com.eyvot.kctapp.domain.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


@Entity
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = Constants.NUMERO_MAXIMO_CARACTERES_NUMERO_CONSULTORIO, nullable = false)
    @Size(max = Constants.NUMERO_MAXIMO_CARACTERES_NUMERO_CONSULTORIO) // ejemplo: 101 Interior A
    @NotBlank
    private String numero;

    @Column(nullable = false)
    @NotNull
    private Integer piso;

    @OneToMany(mappedBy = "consultorio")
    private List<Cita> citas;


    public Consultorio() {}

    public Consultorio(Integer id, String numero, Integer piso, List<Cita> citas) {
        this.id = id;
        this.numero = numero;
        this.piso = piso;
        this.citas = citas;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

}
