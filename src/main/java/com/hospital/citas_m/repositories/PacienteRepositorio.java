package com.hospital.citas_m.repositories;

import com.hospital.citas_m.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {
}
