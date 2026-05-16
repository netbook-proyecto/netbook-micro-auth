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
    
    @Column(nullable = false, unique = true , length = 50)
    private String correo;

    @Column(nullable = false)
    private String contrasenia;

    @Column(nullable = false, length = 50)
    private String rol;
}
