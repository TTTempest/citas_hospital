package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.PacienteDTO;
import com.hospital.citas_m.entities.Paciente;

import java.util.List;

public interface PacienteService {

    List<PacienteDTO> listaPaciente();
    PacienteDTO paciendebyid(Long id);
    void deletePaciente(Long id);
    PacienteDTO savePaciente(Paciente paciente);
    PacienteDTO update (Paciente request, Long id);
}
