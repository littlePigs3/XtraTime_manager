package com.project.xtratime_manager.service;

import com.project.xtratime_manager.model.Usuario;
import com.project.xtratime_manager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

}