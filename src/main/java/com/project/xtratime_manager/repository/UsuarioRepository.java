package com.project.xtratime_manager.repository;

import com.project.xtratime_manager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}