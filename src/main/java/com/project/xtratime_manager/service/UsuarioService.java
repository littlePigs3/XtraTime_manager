package com.project.xtratime_manager.service;

import com.project.xtratime_manager.model.Usuario;
import com.project.xtratime_manager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuarioAtualizado, Long id) {
        Usuario usuario = this.usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado com id: " + id));
        return this.usuarioRepository.save(this.popularUsuario(usuarioAtualizado, usuario));
    }

    private Usuario popularUsuario(Usuario usuarioAtualizado, Usuario usuario) {
        usuario.setIdUsuario(usuarioAtualizado.getIdUsuario());
        usuario.setNmSenha(usuario.getNmSenha());
        usuario.setNivelUsuario(usuario.getNivelUsuario());
        return usuario;
    }

    public List<Usuario> findAll() {return  this.usuarioRepository.findAll();}

    public void delete(Long id) {
        this.usuarioRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String nmLogin) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(nmLogin);
    }
}