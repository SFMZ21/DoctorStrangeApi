package com.example.DoctorStrangeApi.Controllers;

import com.example.DoctorStrangeApi.Entities.Cita;
import com.example.DoctorStrangeApi.Repositories.RepositorioCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value="/citas")
public class ControllerCita {

    @Autowired
    RepositorioCita repositorioCita;

    //CREAR CITA
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Cita crearCita(@RequestBody Cita cita){
        Cita nuevaCita = repositorioCita.save(cita);
        return nuevaCita;
    }

    //LISTAR CITAS
    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public Collection<Cita> listaCitas(){
        Iterable<Cita> citas= repositorioCita.findAll();
        return(Collection<Cita>)citas;
    }

    //BUSCAR CITAS
    @GetMapping(value="/citas/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public Cita buscarCita(@PathVariable(name="id")Long id){
        Optional<Cita> cita = repositorioCita.findById(id);
        Cita buscada = null;
        if(cita.isPresent()){
            buscada = cita.get();
        }
        return buscada;
    }

    //MODIFICAR CITA
    @PutMapping(value="/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Cita modificarCita(@PathVariable(name="id")Long id, @RequestBody Cita cita){
        Optional<Cita> citaAnterior = repositorioCita.findById(id);
        if(citaAnterior.isPresent()){
            Cita modificada = citaAnterior.get();
            modificada.setId(cita.getId());
            modificada.setHora(cita.getHora());
            modificada.setPaciente(cita.getPaciente());
            modificada.setEstado(cita.getEstado());
            modificada.setObservaciones(cita.getObservaciones());
            Cita citaLista = repositorioCita.save(modificada);
            return citaLista;
        }
        return null;
    }

    //BORRAR CITA
    @DeleteMapping(value="/{id}")
    @ResponseStatus(code=HttpStatus.ACCEPTED)
    public void borrarCita(@PathVariable(name="id") Long id){
        repositorioCita.deleteById(id);
    }

}
