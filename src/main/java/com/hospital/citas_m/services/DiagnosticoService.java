package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.DiagnosticoDTO;
import com.hospital.citas_m.entities.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    public List<DiagnosticoDTO> listadiag();
    public DiagnosticoDTO diagById(long id);
    public DiagnosticoDTO guardarDIagnostico(Diagnostico diag);
    public void delete(long id);

}
