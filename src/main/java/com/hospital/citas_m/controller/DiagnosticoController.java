package com.hospital.citas_m.controller;

import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diagnostico")
public class DiagnosticoController {
    @Autowired
    private DiagnosticoService service;
    @GetMapping("/all")
    public List<Diagnostico> listadiagnostico(){
        return service.listaDiagnostico();
    }
}
