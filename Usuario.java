package com.finanzapro.core.modelos;

import java.time.LocalDateTime;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenia;
    private LocalDateTime fechaRegistro;

    // Constructor Vacío
    public Usuario() {}

    // Constructor Parcial para Inserciones
    public Usuario(String nombre, String correo, String contrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    // Getters y Setters (Estándar de Codificación)
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}