package com.misfinanzas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Captura completa de los 8 parámetros del formulario de tu registro.html
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("Telefono");
        String identificacion = request.getParameter("Identificacion");
        String fechaNacimiento = request.getParameter("fecha_nacimiento");
        String password = request.getParameter("password");
        String confirmar = request.getParameter("confirmar");

        // Validación lógica del lado del servidor
        if (!password.equals(confirmar)) {
            response.getWriter().println("<script>alert('Las contraseñas no coinciden.'); window.history.back();</script>");
            return;
        }

        // Aquí se invocaría la capa DAO con JDBC desarrollada en la evidencia anterior:
        System.out.println("Registrando en el sistema a: " + nombre + " " + apellido + " [ID: " + identificacion + "]");

        // Traslado exitoso: Redirige al login dinámico imprimiendo el éxito
        request.setAttribute("error", "¡Registro exitoso! Inicie sesión.");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}