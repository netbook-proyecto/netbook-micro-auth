package com.example.micro_auth.repositories;

<<<<<<< HEAD
import com.example.micro_auth.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepositories extends JpaRepository<Usuario, Long> {
    
    Optional<Usuario> findByCorreoInstitucional(String correoInstitucional);
    
    boolean existsByCorreoInstitucional(String correoInstitucional);
}
=======
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro_auth.models.entities.Usuario;

import java.util.Optional;

public interface UsuarioRepositories  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoInstitucional(String correo);


    
}
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
