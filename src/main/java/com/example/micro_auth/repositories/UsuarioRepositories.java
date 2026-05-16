package com.example.micro_auth.repositories;

import com.example.micro_auth.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepositories  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);


    
}