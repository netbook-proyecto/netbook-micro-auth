package com.example.micro_auth.models.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequest {
    @NotBlank
    private String correoInstitucional; 
    @NotBlank
    private String contrasenia;
    @NotBlank
    private String rol;
}