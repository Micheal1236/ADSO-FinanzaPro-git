package com.misfinanzas.api.controller;

import com.misfinanzas.api.dto.LoginRequest;
import com.misfinanzas.api.model.Usuario;
import com.misfinanzas.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST que expone los servicios web de Autenticación y Registro.
 */
@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Permite el consumo transversal desde el frontend (React/HTML)
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * SERVICIO WEB: Registro de nuevos usuarios.
     * @param nuevoUsuario Datos enviados en formato JSON en el cuerpo de la petición.
     * @return Respuesta HTTP con el estado del proceso.
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody Usuario nuevoUsuario) {
        // Validación: Verificar si el correo electrónico ya se encuentra registrado
        if (usuarioRepository.findByCorreo(nuevoUsuario.getCorreo()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "El correo electrónico ya está registrado."));
        }

        // Persistir el usuario en la base de datos relacional
        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    /**
     * SERVICIO WEB: Inicio de sesión (Autenticación del caso práctico).
     * @param loginData DTO con las credenciales (usuario/correo y contraseña).
     * @return Mensaje de éxito con HTTP 200 o error controlado con HTTP 401.
     */
    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody LoginRequest loginData) {
        // Buscar el usuario por su correo electrónico en el repositorio
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(loginData.getCorreo());

        // Condicional: Validar si el usuario existe y si la contraseña coincide exactamente
        if (usuarioOpt.isPresent() && usuarioOpt.get().getContrasenia().equals(loginData.getContrasenia())) {
            // Retorno Exitoso: Se cumple con la salida requerida por la guía
            return ResponseEntity.ok(Map.of("mensaje", "Autenticación satisfactoria"));
        }

        // Retorno de Error: Si alguna condición falla, devuelve el error técnico controlado
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("error", "Error en la autenticación: Credenciales incorrectas."));
    }
}