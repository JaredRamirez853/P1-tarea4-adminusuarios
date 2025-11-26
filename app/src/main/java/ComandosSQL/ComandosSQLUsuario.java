/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ComandosSQL;
import Configuración.conexiónBasedeDatos;  
import PersonaYUsuario.Usuario;               

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsula todas las operaciones SQL asociadas a la tabla 'usuarios'.
 * Se utiliza como capa de acceso a datos por encima de la conexión.
 * 
 @author ramir
 */
public class ComandosSQLUsuario {
    /**
     * Devuelve una conexión válida usando la clase conexiónBasedeDatos.
     * Lanza SQLException si por alguna razón no se puede obtener.
     */
    private Connection obtenerConexion() throws SQLException {
        Connection cn = conexiónBasedeDatos.getConnection(); // usa tu método estático
        if (cn == null) {
            throw new SQLException("No se pudo obtener la conexión a la base de datos.");
        }
        return cn;
    }

    // ------------------------------------------------------------------------------------
    // INSERTAR
    // ------------------------------------------------------------------------------------
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios "
                   + "(UserName, Nombre, Apellido, Email, Telefono, Password) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection cn = obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            // Mapeo de atributos de Usuario → columnas de la tabla
            ps.setString(1, usuario.getNombreUsuario());        // UserName
            ps.setString(2, usuario.getNombre());               // Nombre
            ps.setString(3, usuario.getApellido());             // Apellido
            ps.setString(4, usuario.getCorreoElectronico());    // Email
            ps.setString(5, usuario.getNumeroTelefono());       // Telefono
            ps.setString(6, usuario.getClaveAcceso());          // Password

            int filas = ps.executeUpdate();
            System.out.println("[INFO] Usuario insertado. Filas afectadas: " + filas);
            return filas > 0;

        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo insertar el usuario: " + e.getMessage());
            return false;
        }
    }

    // ------------------------------------------------------------------------------------
    // LISTAR TODOS
    // ------------------------------------------------------------------------------------
    public List<Usuario> obtenerTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT UserName, Nombre, Apellido, Email, Telefono, Password FROM usuarios";

        try (Connection cn = obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getString("Nombre"),     // nombre
                        rs.getString("Apellido"),   // apellido
                        rs.getString("Email"),      // correo
                        rs.getString("Telefono"),   // telefono
                        rs.getString("UserName"),   // nombreUsuario
                        rs.getString("Password")    // claveAcceso
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudieron obtener los usuarios: " + e.getMessage());
        }

        return lista;
    }

    // ------------------------------------------------------------------------------------
    // BUSCAR POR USERNAME
    // ------------------------------------------------------------------------------------
    public Usuario buscarPorUsername(String username) {
        String sql = "SELECT UserName, Nombre, Apellido, Email, Telefono, Password "
                   + "FROM usuarios WHERE UserName = ?";

        try (Connection cn = obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                            rs.getString("Nombre"),
                            rs.getString("Apellido"),
                            rs.getString("Email"),
                            rs.getString("Telefono"),
                            rs.getString("UserName"),
                            rs.getString("Password")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("[ERROR] Error al buscar usuario: " + e.getMessage());
        }

        return null;
    }

    // ------------------------------------------------------------------------------------
    // ACTUALIZAR
    // ------------------------------------------------------------------------------------
    public boolean actualizarUsuario(String usernameOriginal, Usuario datosNuevos) {
        String sql = "UPDATE usuarios SET "
                   + "UserName = ?, Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, Password = ? "
                   + "WHERE UserName = ?";

        try (Connection cn = obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, datosNuevos.getNombreUsuario());
            ps.setString(2, datosNuevos.getNombre());
            ps.setString(3, datosNuevos.getApellido());
            ps.setString(4, datosNuevos.getCorreoElectronico());
            ps.setString(5, datosNuevos.getNumeroTelefono());
            ps.setString(6, datosNuevos.getClaveAcceso());
            ps.setString(7, usernameOriginal);

            int filas = ps.executeUpdate();
            System.out.println("[INFO] Usuario actualizado. Filas afectadas: " + filas);
            return filas > 0;

        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo actualizar el usuario: " + e.getMessage());
            return false;
        }
    }

    // ------------------------------------------------------------------------------------
    // ELIMINAR
    // ------------------------------------------------------------------------------------
    public boolean eliminarUsuario(String username) {
        String sql = "DELETE FROM usuarios WHERE UserName = ?";

        try (Connection cn = obtenerConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, username);
            int filas = ps.executeUpdate();
            System.out.println("[INFO] Usuario eliminado. Filas afectadas: " + filas);
            return filas > 0;

        } catch (SQLException e) {
            System.err.println("[ERROR] No se pudo eliminar el usuario: " + e.getMessage());
            return false;
        }
    }
}