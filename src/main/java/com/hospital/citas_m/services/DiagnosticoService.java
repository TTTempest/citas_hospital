package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Diagnostico;
import java.util.List;

public interface DiagnosticoService {
    List<Diagnostico> listaDiagnostico();
    Diagnostico diagnosticobyid(long id);
    void deleteDiagnostico(long id);
    void saveDiagnostico(Diagnostico diagnostico);
}
