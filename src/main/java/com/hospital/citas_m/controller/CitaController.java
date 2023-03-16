package com.hospital.citas_m.controller;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.entities.Cita;
import com.hospital.citas_m.entities.Diagnostico;
import com.hospital.citas_m.services.CitaService;
import com.hospital.citas_m.services.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cita")
public class CitaController {
    @Autowired
    private CitaService citaserv;

   @GetMapping("/all")
   public List<CitaDTO> listaCitas(){
       List<CitaDTO> citas = citaserv.listacita();
       if (citas.isEmpty()){
           throw new RuntimeException("no hay citas");
       }else {
           return citas;
       }

   }
    @GetMapping("/all/{id}")
    public CitaDTO citaId(@PathVariable long id){
        CitaDTO citaDTO = citaserv.listaById(id);
       return citaDTO;
    }
    @PostMapping("/all")
    public CitaDTO guardar(@RequestBody Cita c){
        return citaserv.guardarCita(c);
    }
    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
      CitaDTO dto = citaserv.listaById(id);
      if (dto != null){
          citaserv.delete(id);
      }else {
          throw new RuntimeException("no existe una cita con esa id");
      }
   }
}
