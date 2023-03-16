package com.hospital.citas_m.controller;

import com.hospital.citas_m.DTO.UsuarioDTO;
import com.hospital.citas_m.entities.UsuarioEnt;
import com.hospital.citas_m.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/all")
    public List<UsuarioDTO> listaUsuarios(){
        List<UsuarioDTO> us = service.listaUsuarios();
        if (us.isEmpty()){
            throw new RuntimeException("no hay usuarios");
        }else {
            return us;
        }

    }
    @GetMapping("/all/{id}")
    public UsuarioDTO usuarioById(@PathVariable long id){
        UsuarioDTO DTO = service.usuarioByid(id);
        return DTO;
    }
    @PostMapping("/all")
    public UsuarioDTO guardar(@RequestBody UsuarioEnt us){
        return service.saveUsuario(us);
    }
    @DeleteMapping("/all/{id}")
    public void delete(@PathVariable long id){
        UsuarioDTO dto = service.usuarioByid(id);
        if (dto != null){
            service.deleteUsuario(id);
        }else {
            throw new RuntimeException("no existe un usuario con esa id");
        }
    }
}
