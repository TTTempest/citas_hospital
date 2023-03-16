package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.entities.Cita;

import java.util.List;

public interface CitaService {
    public List<CitaDTO> listacita();
    public CitaDTO listaById(Long id);
    public CitaDTO guardarCita(Cita newCita);
    public void delete(long id);



}
