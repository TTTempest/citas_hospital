package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.MedicoDTO;
import com.hospital.citas_m.entities.Medico;

import java.util.List;

public interface MedicoService {
    List<MedicoDTO> listaMedico();
    MedicoDTO medicobyId(long id);
    void delete(long id);
    MedicoDTO saveMedico(Medico newMedico);
    MedicoDTO update(Medico request, Long id);
}
