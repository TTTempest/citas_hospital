package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Medico;
import com.hospital.citas_m.repositories.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MedicoServiceImp implements MedicoService {
    @Autowired
    private MedicoRepositorio medicorep;
    @Override
    @Transactional(readOnly = true)
    public List<Medico> listaMedico() {
        return (List<Medico>) medicorep.findAll();
    }

    @Override
    public Medico medicobyId(long id) {
        return medicorep.findById(id).orElse(null);
    }

    @Override
    public void deleteMedico(long id) {
        medicorep.deleteById(id);
    }

    @Override
    public void saveMedico(Medico medico) {
        medicorep.save(medico);
    }
}
