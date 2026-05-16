package com.example.micro_auth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    
    @NotBlank(message = "El correo_institucional es obligatorio")
    private String correo_institucional;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;

}
