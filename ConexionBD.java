package com.finanzapro.core.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3606/finanzapro_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contrasenia_sql";

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC de MySQL no encontrado.", e);
        }
    }
}