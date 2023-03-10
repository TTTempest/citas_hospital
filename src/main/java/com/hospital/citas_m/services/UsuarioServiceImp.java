package com.hospital.citas_m.services;

import com.hospital.citas_m.entities.Usuario;
import com.hospital.citas_m.repositories.UsuarioRpositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    private UsuarioRpositorio usuariorep;
    @Override
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) usuariorep.findAll();
    }

    @Override
    public Usuario usuarioByid(long id) {
        return usuariorep.findById(id).orElse(null);
    }

    @Override
    public void deleteUsuario(long id) {
        usuariorep.deleteById(id);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuariorep.save(usuario);
    }
}
