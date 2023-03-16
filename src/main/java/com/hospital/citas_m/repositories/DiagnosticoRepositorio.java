package com.hospital.citas_m.repositories;

import com.hospital.citas_m.entities.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticoRepositorio extends JpaRepository<Diagnostico, Long> {
    Diagnostico findDiagById(long id);
}
