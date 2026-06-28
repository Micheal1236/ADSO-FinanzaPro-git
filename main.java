package com.finanzapro.core.principal;

import com.finanzapro.core.dao.UsuarioDAO;
import com.finanzapro.core.dao.UsuarioDAOImpl;
import com.finanzapro.core.modelos.Usuario;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

        System.out.println("=== 1. OPERACIÓN INSERCIÓN ===");
        Usuario nuevoUsuario = new Usuario("Carlos Mendoza", "carlos@correo.com", "securePass123");
        if (usuarioDAO.insertar(nuevoUsuario)) {
            System.out.println("Usuario registrado con éxito mediante JDBC.");
        }

        System.out.println("\n=== 2. OPERACIÓN CONSULTA ===");
        usuarioDAO.consultarTodos().forEach(u -> {
            System.out.println("ID: " + u.getIdUsuario() + " | Nombre: " + u.getNombre() + " | Correo: " + u.getCorreo());
        });

        System.out.println("\n=== 3. OPERACIÓN ACTUALIZACIÓN ===");
        Usuario usuarioExistente = usuarioDAO.consultarPorId(1);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre("Carlos Mendoza Modificado");
            usuarioDAO.actualizar(usuarioExistente);
            System.out.println("Nombre actualizado en base de datos.");
        }
    }
}