package com.example.micro_auth.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
<<<<<<< HEAD
    
    @NotBlank(message = "El correo es obligatorio")
=======

    @NotBlank(message = "El correo institucional es obligatorio")
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
    private String correoInstitucional;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasenia;
<<<<<<< HEAD

}
=======
}
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
