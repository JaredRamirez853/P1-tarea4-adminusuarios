/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import serviciosPrincipales.serviciosUsuario;

/**
 * Controlador encargado de gestionar el inicio de sesión
 * de los usuarios desde la capa de presentación (formularios).
 * @author ramir
 */
public class controladorLogin {
        // Servicio que contiene la lógica de negocio relacionada con usuarios
    private final serviciosUsuario servicioUsuarios;

    /**
     * Al crear el controlador, se inicializa la instancia del servicio.
     */
    public controladorLogin() {
        this.servicioUsuarios = new serviciosUsuario();
    }

    /**
     * Intenta validar las credenciales de acceso de un usuario.
     *
     * @param nombreUsuario nombre de usuario escrito en el formulario
     * @param clave         contraseña escrita en el formulario
     * @return true si las credenciales son correctas, false en caso contrario
     */
    public boolean iniciarSesion(String nombreUsuario, String clave) {
        // El servicio ya se encarga de manejar cualquier excepción de BD
        return servicioUsuarios.login(nombreUsuario, clave);
    }
    
}
