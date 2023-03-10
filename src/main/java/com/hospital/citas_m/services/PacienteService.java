package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> listaPaciente();
    Paciente paciendebyid(long id);
    void deletePaciente(long id);
    void savePaciente(Paciente paciente);
}
