/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersonaYUsuario;

/**
 *
 * @author ramir
 */
public class persona {
    // Información fundamental de la persona
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String numeroTelefono;

    /**
     * Constructor principal. Asigna los valores iniciales de la persona.
     *
     * @param nombre           Nombre de la persona
     * @param apellido         Apellido de la persona
     * @param correoElectronico Correo electrónico asociado
     * @param numeroTelefono    Teléfono de contacto
     */
    public persona(String nombre, String apellido, String correoElectronico, String numeroTelefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
    }

    // ------------------------ GETTERS ------------------------

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    // ------------------------ SETTERS ------------------------

    public void setNombre(String nNombre) {
        this.nombre = nNombre;
    }

    public void setApellido(String nApellido) {
        this.apellido = nApellido;
    }

    public void setCorreoElectronico(String nCorreo) {
        this.correoElectronico = nCorreo;
    }

    public void setNumeroTelefono(String nTelefono) {
        this.numeroTelefono = nTelefono;
    }
}
