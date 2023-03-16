package com.hospital.citas_m.controller;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.PacienteDTO;
import com.hospital.citas_m.entities.Medico;
import com.hospital.citas_m.entities.Paciente;
import com.hospital.citas_m.services.PacienteService;
import com.hospital.citas_m.services.PacienteServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class pacienteController {
    @Autowired
    private PacienteService service;

    @GetMapping("/all")
    public List<PacienteDTO> listapaciente(){
        List<PacienteDTO> paciente = service.listaPaciente();
        return paciente;
    }
    @GetMapping("/all/{id}")
    public PacienteDTO pacienteId(@PathVariable long id){
        PacienteDTO DTO = service.paciendebyid(id);
        return DTO;
    }
    @PostMapping("/all")
    public PacienteDTO guardar(@RequestBody Paciente dto){
        return service.savePaciente(dto);
    }
    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        PacienteDTO dto = service.paciendebyid(id);
        if (dto != null){
            service.deletePaciente(id);
        }else {
            throw new RuntimeException("no existe una cita con esa id");
        }
    }
    @PutMapping("/all/{id}")
    public void update(@RequestBody Paciente request, @PathVariable Long id){
        service.update(request, id);
    }
}
