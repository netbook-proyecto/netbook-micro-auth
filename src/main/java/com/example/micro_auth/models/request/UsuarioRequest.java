package com.example.micro_auth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequest {

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;


    
}
