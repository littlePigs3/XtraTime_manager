    package com.project.xtratime_manager.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class    Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idUsuario;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String nmSenha;

    @Column(nullable = false)
    private NivelUsuarioEnum nivelUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.nivelUsuario == NivelUsuarioEnum.ADMIN) {
            return List.of(new SimpleGrantedAuthority("NIVELUSUARIO_ADMIN"),
                    new SimpleGrantedAuthority("NIVELUSUARIO_ADMINSETOR"),
                    new SimpleGrantedAuthority("NIVELUSUARIO_USER"));
        } else if (this.nivelUsuario == NivelUsuarioEnum.ADMINSETOR) {
            return List.of(new SimpleGrantedAuthority("NIVELUSUARIO_ADMINSETOR"),
                    new SimpleGrantedAuthority("NIVELUSUARIO_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("NIVELUSUARIO_USER"));
        }
    }

    @Override
    public String getPassword() {
        return nmSenha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}