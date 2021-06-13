package com.example.DoctorStrangeApi.Entities;

import javax.persistence.*;

@Entity
@Table(name="pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(name="primerNombre")
    private String primerNombre;

    @Column(name="segundoNombre")
    private String segundoNombre;

    @Column(name="primerApellido")
    private String primerApellido;

    @Column(name="segundoApellido")
    private String segundoApellido;

    @Column(name="edad")
    private Integer edad;

    //constructor
    public Paciente(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,Integer edad){
        this.id= id;
        this.primerNombre= primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido =primerApellido;
        this.segundoApellido= segundoApellido;
        this.edad= edad;

    }
    public Paciente(){super();}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
