package com.finanzapro.core.dao;

import com.finanzapro.core.modelos.Usuario;
import java.util.List;

public interface UsuarioDAO {
    boolean insertar(Usuario usuario);
    Usuario consultarPorId(int idUsuario);
    List<Usuario> consultarTodos();
    boolean actualizar(Usuario usuario);
    boolean eliminar(int idUsuario);
}