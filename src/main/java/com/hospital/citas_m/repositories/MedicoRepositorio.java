package com.hospital.citas_m.repositories;

import com.hospital.citas_m.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepositorio extends JpaRepository<Medico, Long> {
}
