<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Registrarse</title>
</head>
<body>
    <div class="container" style="height: auto; min-height: 600px; padding-bottom: 20px;">
    <h1>Mis Finanzas</h1>
    <h2>Registrarse</h2>

    <form action="RegistroServlet" method="POST">
      <input type="text" name="nombre" placeholder="Nombre" required>
      <input type="text" name="apellido" placeholder="Apellido" required>
      <input type="email" name="correo" placeholder="Correo electrónico" required>
      <input type="tel" name="Telefono" placeholder="Número de teléfono" required>
      <input type="text" name="Identificacion" placeholder="Número de identificación" required>
      <input type="date" name="fecha_nacimiento" required>
      <input type="password" name="password" placeholder="Contraseña" required>
      <input type="password" name="confirmar" placeholder="Confirmar contraseña" required>

      <button type="submit">Registrar</button>
      <a href="index.jsp" class="btn-link secondary-btn" style="text-decoration: none; display: inline-block; margin-top: 10px;">Cancelar</a>
    </form>
  </div>
</body>
</html>