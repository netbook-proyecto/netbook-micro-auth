package com.example.micro_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.micro_auth.models.entities.Usuario;
import com.example.micro_auth.models.request.LoginRequest;
import com.example.micro_auth.models.request.UsuarioRequest;
import com.example.micro_auth.repositories.UsuarioRepositories;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    // Registrar Usuario
    public void register(UsuarioRequest request) {
        if (usuarioRepositories.findByCorreoInstitucional(request.getCorreoInstitucional()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo ya existe: " + request.getCorreoInstitucional());
        }

        Usuario usuario = new Usuario();
        usuario.setCorreoInstitucional(request.getCorreoInstitucional());
        
        usuario.setCorreoInstitucional(request.getCorreoInstitucional());
        
        usuario.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        usuario.setRol(request.getRol());

        usuarioRepositories.save(usuario);
    }

    // Iniciar Sesion
    public String login(LoginRequest request) {
        
        Usuario usuario = usuarioRepositories.findByCorreoInstitucional(request.getCorreo_institucional())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));
    
        if (!passwordEncoder.matches(request.getContrasenia(), usuario.getContrasenia())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña incorrecta");
        }
        
        return jwtService.generateToken(usuario.getCorreoInstitucional(), usuario.getRol());
    }
}