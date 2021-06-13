package com.example.DoctorStrangeApi.Controllers;

import com.example.DoctorStrangeApi.Entities.Paciente;
import com.example.DoctorStrangeApi.Repositories.RepositorioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(value="/pacientes")
public class ControllerPaciente {

    @Autowired
    RepositorioPaciente repositorioPaciente;

    //CREAR PACIENTES
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Paciente nuevoPaciente(@RequestBody Paciente paciente, @DateTimeFormat(pattern = "yyyy.MM.ddd") Date date){
        Paciente nuevoPaciente =repositorioPaciente.save(paciente);
        return nuevoPaciente;
    }

    //LISTAR PACIENTES
    @GetMapping
    @ResponseStatus(code=HttpStatus.OK)
    public Collection<Paciente> listaPacientes(){
        Iterable<Paciente>pacientes= repositorioPaciente.findAll();
        return(Collection<Paciente>)pacientes;

    }

    //BUSCAR PACIENTES
    @GetMapping(value="/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Paciente buscarPaciente(@PathVariable(name="id") Long id){
        Optional<Paciente> paciente= repositorioPaciente.findById(id);
        Paciente buscado= null;

        if(paciente.isPresent()){
            buscado = paciente.get();
        }
        return buscado;
    }

    //EDITAR PACIENTES
    @PutMapping(value="/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public Paciente editarPaciente(@PathVariable(name="id")Long id, @RequestBody Paciente paciente){
        Optional<Paciente> pacienteAntiguo= repositorioPaciente.findById(id);
        if(pacienteAntiguo.isPresent()){
            Paciente actual = pacienteAntiguo.get();
            actual.setId(id);
            actual.setPrimerNombre(paciente.getPrimerNombre());
            actual.setSegundoNombre(paciente.getSegundoNombre());
            actual.setPrimerApellido(paciente.getPrimerApellido());
            actual.setSegundoApellido(paciente.getSegundoApellido());
            actual.setEdad(paciente.getEdad());
            Paciente PacienteModificado = repositorioPaciente.save(actual);
            return PacienteModificado;
        }
        return null;
    }

    //BORRAR PACIENTE
    @DeleteMapping(value="/{id}")
    @ResponseStatus(code= HttpStatus.ACCEPTED)
    public void borrarPaciente(@PathVariable(name="id")Long id){
        repositorioPaciente.deleteById(id);
    }


}
