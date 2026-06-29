package com.misfinanzas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // USO DEL MÉTODO GET: Redirige al formulario inicial de manera segura
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    // USO DEL MÉTODO POST: Procesa los datos del formulario de autenticación
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String contrasenia = request.getParameter("password");

        // Simulación lógica de validación de credenciales (Mock de pruebas)
        if ("admin@finanzas.com".equals(usuario) && "12345".equals(contrasenia)) {
            // Guardamos el usuario en el contexto para simular la sesión dinámica en el JSP
            request.setAttribute("usuarioLogueado", usuario);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            // Envío de retroalimentación en caso de error
            request.setAttribute("error", "Credenciales incorrectas. Intente de nuevo.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}