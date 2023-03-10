package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.repositories.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CitaServiceImp implements CitaService{

    @Autowired
    private CitaRepositorio citarep;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> listaCita() {
        return (List<Cita>) citarep.findAll();
    }

    @Override
    public Cita listaid(long id) {
        return (Cita) citarep.findById(id).orElse(null);
    }


/*
    @Override
    @Transactional(readOnly = true)
    public List<Cita> buscarporfecha(Date fecha) {
        return citarep.findbyFechaHora(fecha);
    }

 */

    @Override
    public void deleteCita(long id) {
        citarep.deleteById(id);
    }

    @Override
    public Cita saveCita(Cita cita) {
    citarep.save(cita);
        return cita;
    }





}
