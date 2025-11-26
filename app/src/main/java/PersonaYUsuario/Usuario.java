/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaYUsuario;

/**
 *
 * @author ramir
 */
public class Usuario extends persona{
        // Credenciales del usuario dentro del sistema
    private String nombreUsuario;
    private String claveAcceso;

    /**
     * Construye un nuevo usuario con toda su información personal y de acceso.
     *
     * @param nombre          Nombre del usuario
     * @param apellido        Apellido del usuario
     * @param correo          Correo electrónico
     * @param telefono        Número telefónico
     * @param nombreUsuario   Nombre de usuario (username)
     * @param claveAcceso     Contraseña del usuario
     */
    public Usuario(String nombre, String apellido, String correo, String telefono,
                String nombreUsuario, String claveAcceso) {

        // Inicializa la parte correspondiente a la clase padre
        super(nombre, apellido, correo, telefono);

        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
    }

    // -----------------------------
    // Getters y Setters 
    // -----------------------------

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nuevoNombreUsuario) {
        this.nombreUsuario = nuevoNombreUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String nuevaClave) {
        this.claveAcceso = nuevaClave;
    }
}
