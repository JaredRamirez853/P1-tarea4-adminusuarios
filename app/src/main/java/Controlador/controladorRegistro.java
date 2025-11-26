package Controlador;

import serviciosPrincipales.serviciosUsuario;

/**
 * Controlador encargado del proceso de registro de usuarios.
 */
public class controladorRegistro {

    private final serviciosUsuario servicio;

    public controladorRegistro() {
        this.servicio = new serviciosUsuario();
    }

    /**
     * Recibe los datos del formulario, los envía al servicio y devuelve true
     * si el registro fue exitoso, o false si falló.
     */
    public boolean registrarUsuario(
            String nombre,
            String apellido,
            String correo,
            String telefono,
            String nombreUsuario,
            String clave,
            String confirmarClave) {

        try {
            // El servicio se encarga de validar y registrar
            return servicio.registrarUsuario(
                    nombre,
                    apellido,
                    correo,
                    telefono,
                    nombreUsuario,
                    clave,
                    confirmarClave
            );
        } catch (Exception e) {
            // Evita que el formulario explote por excepciones internas
            System.err.println("[ERROR] No se pudo registrar el usuario: " + e.getMessage());
            return false;
        }
    }
}