package com.example.micro_auth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "El correo institucional es obligatorio")
    private String correoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;
}