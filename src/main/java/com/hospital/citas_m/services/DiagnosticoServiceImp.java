package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.repositories.DiagnosticoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiagnosticoServiceImp implements DiagnosticoService{
    @Autowired
    private DiagnosticoRepositorio diagnosticorep;
    @Override
    public List<Diagnostico> listaDiagnostico() {
        return (List<Diagnostico>) diagnosticorep.findAll();
    }

    @Override
    public Diagnostico diagnosticobyid(long id) {
        return diagnosticorep.findById(id).orElse(null);
    }

    @Override
    public void deleteDiagnostico(long id) {
        diagnosticorep.deleteById(id);
    }

    @Override
    public void saveDiagnostico(Diagnostico diagnostico) {
        diagnosticorep.save(diagnostico);
    }
}
