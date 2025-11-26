/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import serviciosPrincipales.serviciosUsuario;


/**
 *
 * @author ramir
 */
public class controladorRegistro {
    // Servicio que contiene la lógica de negocio relacionada con usuarios
    private final serviciosUsuario servicioUsuarios;

    /**
     * Constructor: inicializa la instancia del servicio.
     */
    public controladorRegistro() {
        this.servicioUsuarios = new serviciosUsuario();
    }

    /**
     * Intenta registrar un nuevo usuario con los datos proporcionados.
     *
     * @param nombre          Nombre del usuario
     * @param apellido        Apellido del usuario
     * @param correo          Correo electrónico
     * @param telefono        Número de teléfono
     * @param nombreUsuario   Username del usuario
     * @param clave           Contraseña
     * @param confirmarClave  Confirmación de la contraseña
     * @return true si el registro fue exitoso, false si ocurrió algún problema
     */
    public boolean registrar(String nombre,
                             String apellido,
                             String correo,
                             String telefono,
                             String nombreUsuario,
                             String clave,
                             String confirmarClave) {

        // Delegamos toda la validación y acceso a BD al servicio
        return servicioUsuarios.registrarUsuario(
                nombre,
                apellido,
                correo,
                telefono,
                nombreUsuario,
                clave,
                confirmarClave
        );
    }

}
