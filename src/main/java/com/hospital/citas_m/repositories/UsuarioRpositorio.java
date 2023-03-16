package com.hospital.citas_m.repositories;

import com.hospital.citas_m.entities.UsuarioEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRpositorio extends JpaRepository<UsuarioEnt, Long>{

}
