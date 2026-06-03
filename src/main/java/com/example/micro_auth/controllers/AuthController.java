package com.example.micro_auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.micro_auth.services.AuthService;
import com.example.micro_auth.models.request.LoginRequest;
import com.example.micro_auth.models.request.UsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "AuthController", description = "Controlador de autenticación y registro de usuarios")
public class AuthController {
 
    @Autowired
    private AuthService authService;

<<<<<<< HEAD
    
    @PostMapping("/register")
    @Operation(summary = "Registrar un nuevo usuario", description = "Registra un nuevo usuario en el sistema y le asigna un rol según su correo")
    public ResponseEntity<String> register(@Valid @RequestBody UsuarioRequest request) {
        String respuesta = authService.registrarUsuario(request);
        return ResponseEntity.ok(respuesta);
=======
    @PostMapping("/register")
    @Operation(summary = "Registrar un nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    public ResponseEntity<String> register(@Valid @RequestBody UsuarioRequest request) {
        authService.register(request);
        return ResponseEntity.ok("Usuario registrado exitosamente");
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
    }

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Inicia sesión en el sistema")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(request);
        return ResponseEntity.ok(token);
    }

}
