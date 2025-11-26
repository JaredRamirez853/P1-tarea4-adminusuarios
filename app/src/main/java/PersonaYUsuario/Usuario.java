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
          private String nombreUsuario;
    private String claveAcceso;

    public Usuario(String nombre, String apellido, String correo, String telefono,
                   String nombreUsuario, String claveAcceso) {

        super(nombre, apellido, correo, telefono);  // heredado de Persona
        this.nombreUsuario = nombreUsuario;
        this.claveAcceso = claveAcceso;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }
}
