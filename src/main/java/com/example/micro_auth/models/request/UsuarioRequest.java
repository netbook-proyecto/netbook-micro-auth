package com.example.micro_auth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequest {

    @NotBlank(message = "El correo es obligatorio")
    private String correoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;


    
}
