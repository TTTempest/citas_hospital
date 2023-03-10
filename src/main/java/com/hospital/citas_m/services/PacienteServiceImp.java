package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Paciente;
import com.hospital.citas_m.repositories.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PacienteServiceImp implements PacienteService {
    @Autowired
    private PacienteRepositorio pacienteRep;
    @Override
    @Transactional(readOnly = true)
    public List<Paciente> listaPaciente() {
        return (List<Paciente>) pacienteRep.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente paciendebyid(long id) {
        return pacienteRep.findById(id).orElse(null);
    }

    @Override
    public void deletePaciente(long id) {
    pacienteRep.deleteById(id);
    }

    @Override
    public void savePaciente(Paciente paciente) {
    pacienteRep.save(paciente);
    }
}
