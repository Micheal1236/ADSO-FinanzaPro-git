<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Dashboard - Mis Finanzas</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1 style="color: #2ecc71;">Mis Finanzas</h1>
        <%-- Elemento JSP: Uso de expresiones dinámicas para saludar al usuario autenticado --%>
        <h2>Bienvenido, <%= (request.getAttribute("usuarioLogueado") != null) ? request.getAttribute("usuarioLogueado") : "Usuario" %></h2>
        
        <p style="text-align: left; margin-top: 20px;">Módulo Web del Proyecto Formativo inicializado y probado con éxito mediante servlets de Java Enterprise.</p>
        
        <a href="LoginServlet" class="btn-link" style="text-decoration: none; display: inline-block; margin-top: 30px; background-color: #333;">Cerrar sesión</a>
    </div>
</body>
</html>