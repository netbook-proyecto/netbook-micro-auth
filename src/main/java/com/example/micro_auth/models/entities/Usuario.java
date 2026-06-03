package com.example.micro_auth.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
<<<<<<< HEAD
    @Column(name = "correo_institucional", nullable = false, unique = true, length = 100)
=======
    @Column(name = "correo_institucional", nullable = false, unique = true, length = 50)
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
    private String correoInstitucional;

    @Column(nullable = false)
    private String contrasenia;
<<<<<<< HEAD
    
    @Column(nullable = false, length = 20)
    private String rol;
}
    
=======

    @Column(nullable = false, length = 50)
    private String rol;
}
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
