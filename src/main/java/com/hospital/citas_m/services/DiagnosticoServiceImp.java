package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.DiagnosticoDTO;
import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.repositories.DiagnosticoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class DiagnosticoServiceImp implements DiagnosticoService{
    @Autowired
    private DiagnosticoRepositorio diagnosticorep;

    private final ModelMapper maper = new ModelMapper();

    private DiagnosticoDTO convertDTO(Diagnostico d){
        DiagnosticoDTO dto = maper.map(d, DiagnosticoDTO.class);
        return dto;
    }

    @Override
    public List<DiagnosticoDTO> listadiag() {
        List<Diagnostico> diag = diagnosticorep.findAll();
        List<DiagnosticoDTO> DTo= new LinkedList<DiagnosticoDTO>();
        for(Diagnostico d: diag){
            DTo.add(convertDTO(d));
        }
        return DTo;
    }

    @Override
    public DiagnosticoDTO diagById(long id) {
        Diagnostico diag = diagnosticorep.findById(id).orElse(null);
        if (diag == null){
            throw new RuntimeException("Cita no encontrada");
        }else {
            return convertDTO(diag);
        }
    }

    @Override
    public DiagnosticoDTO guardarDIagnostico(Diagnostico diag) {
         diagnosticorep.save(diag);
        return convertDTO(diag);
    }

    @Override
    public void delete(long id) {

        if (diagnosticorep.existsById(id)){
            diagnosticorep.deleteById(id);
        }else {
            throw new RuntimeException("diagnostico no encontrado");
        }
    }

}
