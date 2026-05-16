package com.example.micro_auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_auth.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepositories  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoInstitucional(String correo);


    
}
