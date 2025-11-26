/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviciosPrincipales;
import ComandosSQL.ComandosSQLUsuario;
import PersonaYUsuario.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramir
 */
public class serviciosUsuario {
 // Repositorio de acceso a datos
    private final ComandosSQLUsuario repositorio;

    // Constructor: inicializa el repositorio
    public serviciosUsuario() {
        this.repositorio = new ComandosSQLUsuario();
    }

    // -------------------------------------------------------------------------
    // REGISTRO
    // -------------------------------------------------------------------------
    /**
     * Registra un nuevo usuario después de validar los datos.
     *
     * @return true si el registro fue exitoso, false si hubo algún problema.
     */
    public boolean registrarUsuario(String nombre,
                                    String apellido,
                                    String correo,
                                    String telefono,
                                    String nombreUsuario,
                                    String clave,
                                    String confirmarClave) {

        // Validaciones de campos obligatorios
        if (nombre.isBlank() || apellido.isBlank() || correo.isBlank()
                || telefono.isBlank() || nombreUsuario.isBlank()
                || clave.isBlank() || confirmarClave.isBlank()) {

            System.err.println("[ERROR] Todos los campos son obligatorios.");
            return false;
        }

        if (!clave.equals(confirmarClave)) {
            System.err.println("[ERROR] Las contraseñas no coinciden.");
            return false;
        }

        // Verificar si ya existe un usuario con ese username
        if (repositorio.buscarPorUsername(nombreUsuario) != null) {
            System.err.println("[ERROR] El nombre de usuario ya está en uso.");
            return false;
        }

        // Crear objeto Usuario (por ahora contraseña en texto plano,
     
        Usuario nuevo = new Usuario(
                nombre,
                apellido,
                correo,
                telefono,
                nombreUsuario,
                clave
        );

        // Guardar en la base de datos
        return repositorio.insertarUsuario(nuevo);
    }

    // -------------------------------------------------------------------------
    // LOGIN
    // -------------------------------------------------------------------------
    /**
     * Verifica las credenciales de un usuario.
     *
     * @param nombreUsuario username
     * @param clave         contraseña escrita en el formulario
     * @return true si las credenciales son válidas
     */
    public boolean login(String nombreUsuario, String clave) {

        if (nombreUsuario.isBlank() || clave.isBlank()) {
            System.err.println("[ERROR] Usuario y contraseña son obligatorios.");
            return false;
        }

        Usuario u = repositorio.buscarPorUsername(nombreUsuario);

        if (u == null) {
            System.err.println("[ERROR] Usuario no encontrado. Debe registrarse primero.");
            return false;
        }

        // Comparación simple. Si más adelante quieres hash, se cambia aquí.
        if (!u.getClaveAcceso().equals(clave)) {
            System.err.println("[ERROR] Contraseña incorrecta.");
            return false;
        }

        return true;
    }

    // -------------------------------------------------------------------------
    // OBTENER TODOS
    // -------------------------------------------------------------------------
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> resultado = new ArrayList<>();
        try {
            resultado = repositorio.obtenerTodos();
        } catch (Exception e) {
            System.err.println("[ERROR] No se pudieron cargar los usuarios: " + e.getMessage());
        }
        return resultado;
    }

    // -------------------------------------------------------------------------
    // OBTENER POR USERNAME
    // -------------------------------------------------------------------------
    public Usuario obtenerPorUsername(String username) {
        try {
            return repositorio.buscarPorUsername(username);
        } catch (Exception e) {
            System.err.println("[ERROR] Error al buscar usuario: " + e.getMessage());
            return null;
        }
    }

    // -------------------------------------------------------------------------
    // ACTUALIZAR
    // -------------------------------------------------------------------------
    public boolean actualizarUsuario(String usernameOriginal,
                                     String nombre,
                                     String apellido,
                                     String correo,
                                     String telefono,
                                     String nuevoNombreUsuario,
                                     String nuevaClaveOpcional) {

        // Validaciones básicas
        if (nombre.isBlank() || apellido.isBlank() || correo.isBlank()
                || telefono.isBlank() || nuevoNombreUsuario.isBlank()) {

            System.err.println("[ERROR] Todos los campos son obligatorios para actualizar.");
            return false;
        }

        // Buscar usuario original
        Usuario existente = repositorio.buscarPorUsername(usernameOriginal);
        if (existente == null) {
            System.err.println("[ERROR] Usuario no encontrado. Posiblemente fue eliminado.");
            return false;
        }

        // Actualizar datos en el objeto
        existente.setNombre(nombre);
        existente.setApellido(apellido);
        existente.setCorreoElectronico(correo);
        existente.setNumeroTelefono(telefono);
        existente.setNombreUsuario(nuevoNombreUsuario);

        // Si se envió nueva contraseña, se actualiza
        if (nuevaClaveOpcional != null && !nuevaClaveOpcional.isBlank()) {
            existente.setClaveAcceso(nuevaClaveOpcional);
        }

        // Persistir cambios
        return repositorio.actualizarUsuario(usernameOriginal, existente);
    }

    // -------------------------------------------------------------------------
    // ELIMINAR
    // -------------------------------------------------------------------------
    public boolean eliminarUsuario(String username) {
        return repositorio.eliminarUsuario(username);
    }
    
}
