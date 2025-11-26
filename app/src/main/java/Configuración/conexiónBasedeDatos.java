/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuración;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase responsable de administrar la conexión única hacia la base de datos.
 */

/**
 *
 * @author ramir
 */
public class conexiónBasedeDatos {
        // Conexión única (Singleton)
    private static Connection connectionInstance;

    // Datos de conexión (pueden extraerse de un archivo externo si se desea)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/p1_tarea4?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Jared123";

    /**
     * Devuelve una conexión activa hacia la base de datos.
     * Si la conexión aún no existe, se crea una nueva.
     *
     * @return instancia única de Connection
     */
    public static Connection getConnection() {
        if (connectionInstance == null) {
            try {
                // Intentamos establecer la conexión
                connectionInstance = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                System.out.println("[OK] Conexión con MySQL establecida.");
            } catch (SQLException ex) {
                // Si ocurre un error, se muestra información detallada
                System.err.println("[ERROR] No se pudo conectar con la base de datos.");
                System.err.println("Detalle: " + ex.getMessage());
            }
        }

        return connectionInstance;
    }
}
