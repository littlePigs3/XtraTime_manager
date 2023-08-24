    package com.project.xtratime_manager.repository;

    import com.project.xtratime_manager.model.Usuario;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        UserDetails findByLogin(String nmLogin);
    }