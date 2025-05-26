package util;

import ClasesModelo.Empleado;

/**
 * Esta clase gestiona la sesión del empleado que está actualmente usando la aplicación.
 * Permite iniciar sesión, obtener la información del empleado actual, verificar si hay una sesión activa,
 * cerrar la sesión y comprobar si el empleado actual es administrador.
 */
public class SesionEmpleado {
    private static Empleado empleadoActual = null; // Guarda la información del empleado que ha iniciado sesión.
    private static boolean sesionActiva = false; // Indica si hay alguna sesión activa en este momento.
    private static final String Admin = "Administrador"; // Una constante para identificar el tipo de empleado administrador.

    /**
     * Inicia una sesión en la aplicación para un empleado.
     * Guarda la información del empleado y marca la sesión como activa.
     *
     * @param empleado El objeto {@link Empleado} que ha iniciado sesión.
     * @return {@code true} si el empleado no es nulo y la sesión se inicia correctamente, {@code false} en caso contrario.
     */
    public static boolean iniciarSesion(Empleado empleado) {
        if (empleado != null) {
            empleadoActual = empleado;
            sesionActiva = true;
            return true;
        }
        return false;
    }

    /**
     * Obtiene la información del empleado que tiene la sesión activa.
     *
     * @return El objeto {@link Empleado} de la sesión actual, o {@code null} si no hay sesión activa.
     */
    public static Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    /**
     * Comprueba si hay una sesión activa en la aplicación.
     *
     * @return {@code true} si hay una sesión activa, {@code false} en caso contrario.
     */
    public static boolean isSesionActiva() {
        return sesionActiva;
    }

    /**
     * Cierra la sesión actual, eliminando la información del empleado actual y marcando la sesión como inactiva.
     */
    public static void cerrarSesion() {
        empleadoActual = null;
        sesionActiva = false;
    }

    /**
     * Obtiene el tipo de empleado de la sesión actual (por ejemplo, "vendedor", "administrador").
     *
     * @return El tipo de empleado actual como una cadena, o {@code null} si no hay sesión activa.
     */
    public static String getTipoEmpleadoActual() {
        return empleadoActual != null ? empleadoActual.getTipoEmpleado() : null;
    }

    /**
     * Obtiene el nombre completo del empleado que tiene la sesión activa.
     *
     * @return El nombre y los apellidos del empleado actual, o {@code null} si no hay sesión activa.
     */
    public static String getNombreCompletoEmpleado() {
        if (empleadoActual != null) {
            return empleadoActual.getNombre() + " " + empleadoActual.getApellidos();
        }
        return null;
    }

    /**
     * Comprueba si el empleado de la sesión actual es un administrador.
     *
     * @return {@code true} si el empleado actual es de tipo "Administrador", {@code false} en caso contrario o si no hay sesión activa.
     */
    public static boolean esAdmin(){
        if(empleadoActual != null && empleadoActual.getTipoEmpleado().equals(Admin)){
            return true;
        }
        else{
            return false;
        }
    }
}