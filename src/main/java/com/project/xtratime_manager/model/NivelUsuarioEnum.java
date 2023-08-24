package com.project.xtratime_manager.model;

public enum NivelUsuarioEnum {

    ADMIN("admin"),
    ADMINSETOR("adminsetor"),

    USUARIO("usuario");

    private String nivelUsuario;

    NivelUsuarioEnum(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }
}