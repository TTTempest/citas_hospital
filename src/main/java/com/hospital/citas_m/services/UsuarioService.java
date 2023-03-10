package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listaUsuarios();
    Usuario usuarioByid(long id);
    void deleteUsuario(long id);
    void saveUsuario(Usuario usuario);
}

