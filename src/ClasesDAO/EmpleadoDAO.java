package ClasesDAO;

import ClasesModelo.Empleado;
import util.DatabaseConnection;

import javax.swing.*;
import java.sql.*;

public class EmpleadoDAO {

    /**Loggin**/
    public static Empleado autenticarEmpleado(JTextField correo, JPasswordField contraseña) throws SQLException {
        Empleado empleado = null;
        String sql = "SELECT id, nombre, apellidos, correo, contraseña, tipoempleado " +
                "FROM empleados WHERE correo = ? AND contraseña = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo.getText());
            pstmt.setString(2, new String(contraseña.getPassword()));

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    empleado = new Empleado(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("correo"),
                            rs.getString("tipoempleado"),
                            rs.getString("contraseña")
                    );
                }
            }
        }
        return empleado;
    }

    /**Buscar un empleado por ID**/
    public static Empleado obtenerEmpleadoPorID(int id) throws SQLException{
        String sql = "SELECT id, nombre, apellidos, correo, contraseña, tipoempleado " +
                "FROM empleados WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Empleado(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellidos"),
                            rs.getString("correo"),
                            rs.getString("tipoempleado"),
                            rs.getString("contraseña")
                    );
                }
            }
        }
        return null;
    }

    /**Eliminar un empleado por ID**/
    public static boolean eliminarEmpleado(int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }

    /**Obtener una lista con todos los empleados**/
    public static java.util.List<Empleado> obtenerTodosLosEmpleados() throws SQLException {
        String sql = "SELECT id, nombre, apellidos, correo, tipoempleado, contraseña FROM empleados";

        java.util.List<Empleado> empleados = new java.util.ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                empleados.add(new Empleado(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("tipoempleado"),
                        rs.getString("contraseña")
                ));
            }
        }
        return empleados;
    }

}
