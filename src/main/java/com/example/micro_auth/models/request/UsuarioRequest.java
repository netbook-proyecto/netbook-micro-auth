package com.example.micro_auth.models.request;
<<<<<<< HEAD

=======
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequest {
<<<<<<< HEAD

    @NotBlank(message = "El correo es obligatorio")
    private String correoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;


    
}
=======
    @NotBlank
    private String correoInstitucional; 
    @NotBlank
    private String contrasenia;
    @NotBlank
    private String rol;
}
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
