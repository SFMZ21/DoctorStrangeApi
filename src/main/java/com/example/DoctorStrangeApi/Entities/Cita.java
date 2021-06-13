package com.example.DoctorStrangeApi.Entities;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="citas")
public class Cita {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="fecha")
    private final Date fecha = new Date();

    @Column(name="hora")
    private Integer hora;

    @Column(name="paciente")
    private String paciente;

    @Column(name="estado")
    private String estado;

    @Column(name="observaciones")
    private String observaciones;

    public Cita(Long id, Date fecha, Integer hora, String paciente, String estado, String observaciones){
        this.id= id;
        this.hora = hora;
        this.estado = estado;
        this.observaciones = observaciones;

    }
    public Cita(){super();}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
