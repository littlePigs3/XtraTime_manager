package com.project.xtratime_manager.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", unique = true)
    private Long idUsuario;

    @Column(nullable = false, name = "nm_usuario")
    private String nmUsuario;

    @Column(nullable = false, name = "nm_senha")
    private String nmSenha;
}