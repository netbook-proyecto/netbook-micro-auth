   package com.example.micro_auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.micro_auth.models.entities.Usuario;
import com.example.micro_auth.models.request.LoginRequest;
import com.example.micro_auth.models.request.UsuarioRequest;
import com.example.micro_auth.repositories.UsuarioRepositories;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepositories usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService; 

    public String registrarUsuario(UsuarioRequest request) {
    if (usuarioRepository.existsByCorreoInstitucional(request.getCorreoInstitucional())) {
        throw new RuntimeException("El correo ya existe");
    }

    Usuario nuevoUsuario = new Usuario();
    nuevoUsuario.setCorreoInstitucional(request.getCorreoInstitucional());
    nuevoUsuario.setContrasenia(passwordEncoder.encode(request.getContrasenia()));

    String correo = request.getCorreoInstitucional().toLowerCase();
    
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

        return jwtService.generateToken(usuario.getCorreoInstitucional(), usuario.getRol());
    }
}