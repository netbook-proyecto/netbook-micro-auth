package com.example.micro_auth.repositories;

import com.example.micro_auth.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByCorreoInstitucional(String correoInstitucional);
    
    boolean existsByCorreoInstitucional(String correoInstitucional);
}
