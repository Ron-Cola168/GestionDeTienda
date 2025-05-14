package ClasesDAO;

import ClasesModelo.Empleado;
import util.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class EmpleadoDAO {

    /**Crear Empleado**/
    public boolean crearEmpleado(Empleado empleado){
        String sql = "INSERT INTO empleados (id, nombre, apellidos,tipoempleado,contraseña)\n" +
                "VALUES (ADMIN.SEQ_EMPLEADOS_ID.NEXTVAL, ? , ? , ? , ?);";
        Connection conexion = null;
        PreparedStatement pstmt = null;
        boolean exito = false;

        try {
            conexion = DatabaseConnection.getConnection();
            conexion.setAutoCommit(false);

            pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, Empleado.getNombre());
            pstmt.setString(2, Empleado.getApellidos());
            pstmt.setString(3, Empleado.getCorreo());
            pstmt.setString(4, Empleado.getTipoEmpleado());

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);

            // Si deshabilitaste auto-commit:
            // conn.commit();

        } catch (SQLException e) {
            System.err.println("Error al crear persona: " + e.getMessage());
            // Si usas transacciones:
            // try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            // try { if (conn != null) conn.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); } // Restaurar auto-commit
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            // No cerramos la conexión global aquí, se cierra al final en Main
            // DatabaseConnection.closeConnection();
        }
        return exito;


    }

    /**Loggin**/
    public static boolean autenticarEmpleado(JTextField correo, JPasswordField contraseña) throws SQLException {
        boolean exito = false;
        Empleado empleadoLog = null;
        String sql = "SELECT id_empleado, nombre, apellido, correo, contrasena, tipo_empleado " +
                "FROM empleados WHERE correo = ? AND contrasena = ?"; // Selecciona todas las columnas necesarias

        try (Connection conn = DatabaseConnection.getConnection(); // Obtiene la conexión
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo.getText());
            pstmt.setString(2, contraseña.getPassword().toString());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                empleadoLog = new Empleado();
                empleadoLog.setId(rs.getInt("id"));
                empleadoLog.setNombre(rs.getString("nombre"));
                empleadoLog.setApellidos(rs.getString("apellidos"));
                empleadoLog.setCorreo(rs.getString("correo"));
                empleadoLog.setContraseña(rs.getString("contraseña"));
                empleadoLog.setTipoEmpleado(rs.getString("tipoempleado"));

                if(empleadoLog.getCorreo == correo && empleadoLog.getContraseña()){
                  return exito = true;
                };
            }

        } catch (SQLException e) {

        }
        return exito;
    }

}
