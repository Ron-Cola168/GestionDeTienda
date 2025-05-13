package Empleado;

public class Empleado {

    public static autenticarUsuario(String correo, String contraseña){
      boolean auntenticado = false;
      String sql = "SELECT COUNT(*) FROM empleados WHERE correo = " + correo + "AND contraseña = " + contraseña;
    };
}
