package com.hospital.citas_m.controller;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.DiagnosticoDTO;
import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService service;
    @GetMapping("/all")
    public List<DiagnosticoDTO> listaDiagnosticos(){
        List<DiagnosticoDTO> diag = service.listadiag();
        if (diag.isEmpty()){
            throw new RuntimeException("no hay diagnosticos");
        }else {
            return diag;
        }

    }
    @GetMapping("/all/{id}")
    public DiagnosticoDTO diagnosticoByID(@PathVariable long id){
        DiagnosticoDTO DTO = service.diagById(id);
        return DTO;
    }
    @PostMapping("/all")
    public DiagnosticoDTO guardar(@RequestBody Diagnostico dto){
        return service.guardarDIagnostico(dto);
    }
    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        DiagnosticoDTO dto = service.diagById(id);
        if (dto != null){
            service.delete(id);
        }else {
            throw new RuntimeException("no existe un diagnostico con esa id");
        }
    }

}
