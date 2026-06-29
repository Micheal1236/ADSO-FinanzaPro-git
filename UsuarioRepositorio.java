package com.misfinanzas.api.repository;

import com.misfinanzas.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio JPA para interactuar con la tabla de usuarios sin necesidad de escribir SQL manual.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método derivado para buscar un usuario por su correo electrónico único
    Optional<Usuario> findByCorreo(String correo);
}