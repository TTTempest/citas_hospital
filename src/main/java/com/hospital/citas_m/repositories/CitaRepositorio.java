package com.hospital.citas_m.repositories;

import com.hospital.citas_m.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepositorio extends JpaRepository<Cita, Long> {
    /*
    List<Cita> findbyFechaHora(Date fecha);
     */
    Cita findCitaById(long id);
}
