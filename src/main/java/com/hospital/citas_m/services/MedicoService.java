package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> listaMedico();
    Medico medicobyId(long id);
    void deleteMedico(long id);
    void saveMedico(Medico medico);
}
