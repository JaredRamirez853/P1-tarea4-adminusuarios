/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import PersonaYUsuario.Usuario;
import serviciosPrincipales.serviciosUsuario;

import java.util.List;

/**
  * Controlador encargado de gestionar las operaciones de usuario desde la capa
 * de presentación (formularios): obtener usuarios, crear, actualizar y eliminar.
 * @author ramir
 */
public class controladorUsuarios {
        // Servicio que contiene la lógica de negocio
    private final serviciosUsuario servicio;

    // Constructor: inicializa el servicio
    public controladorUsuarios() {
        this.servicio = new serviciosUsuario();
    }

    /**
     * Devuelve una lista con todos los usuarios registrados.
     */
    public List<Usuario> obtenerTodos() {
        return servicio.obtenerTodosLosUsuarios();
    }

    /**
     * Crea un nuevo usuario después de validar los datos.
     *
     * @return true si se creó correctamente, false si ocurrió algún error.
     */
    public boolean crearUsuario(String nombre,
                                String apellido,
                                String correo,
                                String telefono,
                                String nombreUsuario,
                                String clave,
                                String confirmarClave) {

        return servicio.registrarUsuario(
                nombre,
                apellido,
                correo,
                telefono,
                nombreUsuario,
                clave,
                confirmarClave
        );
    }

    /**
     * Actualiza un usuario existente.
     *
     * @return true si la actualización fue exitosa, false si falló.
     */
    public boolean actualizarUsuario(String usernameOriginal,
                                     String nombre,
                                     String apellido,
                                     String correo,
                                     String telefono,
                                     String nuevoNombreUsuario,
                                     String nuevaClaveOpcional) {

        return servicio.actualizarUsuario(
                usernameOriginal,
                nombre,
                apellido,
                correo,
                telefono,
                nuevoNombreUsuario,
                nuevaClaveOpcional
        );
    }

    /**
     * Elimina un usuario del sistema.
     */
    public boolean eliminarUsuario(String username) {
        return servicio.eliminarUsuario(username);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     */
    public Usuario obtenerUsuario(String username) {
        return servicio.obtenerPorUsername(username);
    }
}
