<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Mis Finanzas - Iniciar Sesión</title>
</head>
<body>
   <div class="container">
    <h1>Mis Finanzas</h1>
    <h2>Iniciar sesión</h2>

    <form action="LoginServlet" method="POST">
      <input type="text" name="usuario" placeholder="Nombre o correo" required>
      <input type="password" name="password" placeholder="Contraseña" required>

      <button type="submit">Iniciar sesión</button>

      <div class="container2">
        <a href="#">Olvidé mi contraseña</a> |
        <a href="registro.jsp">Registrarse</a>
      </div>
    </form>
    
    <%-- Elemento JSP: Captura e impresión de mensajes de error si existen --%>
    <% if(request.getAttribute("error") != null) { %>
        <p style="color: #ef4444; margin-top: 15px; font-weight: 600;"><%= request.getAttribute("error") %></p>
    <% } %>
  </div>
</body>
</html>