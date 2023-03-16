package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.UsuarioDTO;
import com.hospital.citas_m.entities.UsuarioEnt;
import com.hospital.citas_m.repositories.UsuarioRpositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    private UsuarioRpositorio usuariorep;
    private ModelMapper maper = new ModelMapper();

    private UsuarioDTO convertDTO(UsuarioEnt us){
        UsuarioDTO dto = maper.map(us, UsuarioDTO.class);
        return dto;
    }

    @Override
    public List<UsuarioDTO> listaUsuarios() {
        List<UsuarioEnt> us = usuariorep.findAll();
        List<UsuarioDTO> DTo= new ArrayList<>();
        for(UsuarioEnt u: us){
            DTo.add(convertDTO(u));
        }
        return DTo;
    }

    @Override
    public UsuarioDTO usuarioByid(Long id) {
        UsuarioEnt us = usuariorep.findById(id).orElse(null);
        if (us == null){
            throw new RuntimeException("Cita no encontrada");
        }else {
            return convertDTO(us);
        }

    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioEnt newUsuario) {
        usuariorep.save(newUsuario);
        return convertDTO(newUsuario);
    }
    @Override
    public void deleteUsuario(long id) {
        if (usuariorep.existsById(id)) {
            usuariorep.deleteById(id);
        }else{
            throw new RuntimeException("usuario no encontrado");
        }
    }
}
