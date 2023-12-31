package com.project.xtratime_manager.controller;

import com.project.xtratime_manager.model.Usuario;
import com.project.xtratime_manager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        this.usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuario).getBody();
    }

    @PutMapping(path = "{id}")
    public Usuario atualizar(@PathVariable("id") Long id, @RequestBody Usuario usuarioAtualizado){
        this.usuarioService.atualizar(usuarioAtualizado, id);
        return ResponseEntity.ok(usuarioAtualizado).getBody();
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        this.usuarioService.delete(id);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return this.usuarioService.findAll();
    }
}