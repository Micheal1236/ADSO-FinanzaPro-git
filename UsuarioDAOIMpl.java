package com.finanzapro.core.dao;

import com.finanzapro.core.conexion.ConexionBD;
import com.finanzapro.core.modelos.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasenia) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtainConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasenia());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Usuario consultarPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasenia(rs.getString("contrasenia"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> consultarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id_usuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setInt(3, usuario.getIdUsuario());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}