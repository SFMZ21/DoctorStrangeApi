package com.example.DoctorStrangeApi.Repositories;

import com.example.DoctorStrangeApi.Entities.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPaciente extends CrudRepository<Paciente, Long> {
}
