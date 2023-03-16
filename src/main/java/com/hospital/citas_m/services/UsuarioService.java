package com.hospital.citas_m.services;

import com.hospital.citas_m.DTO.UsuarioDTO;
import com.hospital.citas_m.entities.UsuarioEnt;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listaUsuarios();
    UsuarioDTO usuarioByid(Long id);
    void deleteUsuario(long id);
    UsuarioDTO saveUsuario(UsuarioEnt newUsuario);
}

