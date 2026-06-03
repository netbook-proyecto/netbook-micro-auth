package com.example.micro_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
=======
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
import com.example.micro_auth.models.entities.Usuario;
import com.example.micro_auth.models.request.LoginRequest;
import com.example.micro_auth.models.request.UsuarioRequest;
import com.example.micro_auth.repositories.UsuarioRepositories;

@Service
public class AuthService {

    @Autowired
<<<<<<< HEAD
    private UsuarioRepositories usuarioRepository;
=======
    private UsuarioRepositories usuarioRepositories;
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
<<<<<<< HEAD
    private JwtService jwtService; 

    public String registrarUsuario(UsuarioRequest request) {
    if (usuarioRepository.existsByCorreoInstitucional(request.getCorreoInstitucional())) {
        throw new RuntimeException("El correo ya existe");
    }

    Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setCorreoInstitucional(request.getCorreoInstitucional());
    nuevoUsuario.setContrasenia(passwordEncoder.encode(request.getContrasenia()));

    String correo = request.getCorreoInstitucional().toLowerCase();
    
    // Clasificación por palabras clave (Muy fácil de entender y explicar)
    if (correo.contains("alumno")) {
        nuevoUsuario.setRol("ESTUDIANTE");
    } else if (correo.contains("docente")) {
        nuevoUsuario.setRol("DOCENTE");
    } else if (correo.contains("inspector")) {
        nuevoUsuario.setRol("INSPECTOR");
    } else if (correo.contains("directivo")) {
        nuevoUsuario.setRol("DIRECTIVO");
    } else {
        nuevoUsuario.setRol("ADMIN");
    }

    usuarioRepository.save(nuevoUsuario);
    return "Usuario registrado correctamente con el rol: " + nuevoUsuario.getRol();
}

    public String login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreoInstitucional(request.getCorreoInstitucional())
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));

        if (!passwordEncoder.matches(request.getContrasenia(), usuario.getContrasenia())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

=======
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
        
        Usuario usuario = usuarioRepositories.findByCorreoInstitucional(request.getCorreoInstitucional())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "El usuario no existe"));
    
        if (!passwordEncoder.matches(request.getContrasenia(), usuario.getContrasenia())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contraseña incorrecta");
        }
        
>>>>>>> 6d58a006d31a60bb969bddd70f5e9dbbd15f60f0
        return jwtService.generateToken(usuario.getCorreoInstitucional(), usuario.getRol());
    }
}