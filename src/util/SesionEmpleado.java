package util;

import ClasesModelo.Empleado;

public class SesionEmpleado {
    private static Empleado empleadoActual = null;
    private static boolean sesionActiva = false;
    private static final String Admin = "Admin";

    // Inicia la sesión con un empleado
    public static boolean iniciarSesion(Empleado empleado) {
        if (empleado != null) {
            empleadoActual = empleado;
            sesionActiva = true;
            return true;
        }
        return false;
    }

    // Obtiene el empleado actual
    public static Empleado getEmpleadoActual() {
        return empleadoActual;
    }

    // Verifica si hay una sesión activa
    public static boolean isSesionActiva() {
        return sesionActiva;
    }

    // Cierra la sesión actual
    public static void cerrarSesion() {
        empleadoActual = null;
        sesionActiva = false;
    }

    // Obtiene el tipo de empleado actual
    public static String getTipoEmpleadoActual() {
        return empleadoActual != null ? empleadoActual.getTipoEmpleado() : null;
    }

    // Obtiene el nombre completo del empleado actual
    public static String getNombreCompletoEmpleado() {
        if (empleadoActual != null) {
            return empleadoActual.getNombre() + " " + empleadoActual.getApellidos();
        }
        return null;
    }



    public static boolean esAdmin(){
        if(empleadoActual != null && empleadoActual.getTipoEmpleado().equals(Admin)){
            return true;
        }
        else{
            return false;
        }
    }



}