package com.hospital.citas_m.controller;

import com.hospital.citas_m.DTO.CitaDTO;
import com.hospital.citas_m.DTO.MedicoDTO;
import com.hospital.citas_m.entities.Medico;
import com.hospital.citas_m.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoCOntroller {
    @Autowired
    private MedicoService service;
    @GetMapping("/all")
    public List<MedicoDTO> listamedicos(){
        List<MedicoDTO> medicos = service.listaMedico();
        if (medicos.isEmpty()){
            throw new RuntimeException("no hay medicos");
        }else {
            return medicos;
        }
    }
    @GetMapping("/all/{id}")
    public MedicoDTO medicoById(@PathVariable long id){
        MedicoDTO DTO = service.medicobyId(id);
        return DTO;
    }
    @PostMapping("/all")
    public MedicoDTO guardar(@RequestBody Medico dto){
        return service.saveMedico(dto);
    }
    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        MedicoDTO dto = service.medicobyId(id);
        if (dto != null){
            service.delete(id);
        }else {
            throw new RuntimeException("no existe un medico con esa id");
        }
    }
    @PutMapping("/all/{id}")
    public void update(@RequestBody Medico request, @PathVariable Long id){
            service.update(request, id);
    }
}
