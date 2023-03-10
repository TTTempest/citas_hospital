package com.hospital.citas_m.controller;

import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.services.CitaService;
import com.hospital.citas_m.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cita")
public class CitaController {
    @Autowired
    private CitaService citaserv;
    @Autowired
    private DiagnosticoService diagnosticoserv;

    @GetMapping("/all")
    public List<Cita> listadiagnostico(){
        return citaserv.listaCita();
    }
    @GetMapping("/{id}")
    public Cita citasbyid(long id){
        return citaserv.listaid(id);
    }
    @PostMapping("/all")
    public Cita savecita(@RequestBody Cita cita){
        return citaserv.saveCita(cita);
    }
    /*
    @DeleteMapping("/all")
    public String deleteCita(@RequestBody long id){
        Cita cita = citaserv
         citaserv.deleteCita(id);
    }

     */

}
