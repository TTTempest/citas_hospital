package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Cita;

import java.util.List;

public interface CitaService {
    List<Cita> listaCita();
/*
    List<Cita> buscarporfecha(Date fecha);

*/
   Cita listaid(long id);

    void deleteCita(long id);
    Cita saveCita(Cita cita);

}
