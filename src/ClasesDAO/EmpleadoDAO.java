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

    public static boolean insertarEmpleado(Empleado empleado) throws SQLException {
        String sql = "INSERT INTO EMPLEADOS (NOMBRE, APELLIDOS, TIPOEMPLEADO, CONTRASEÑA) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean exito = false;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellidos());
            pstmt.setString(3, empleado.getTipoEmpleado());
            pstmt.setString(4, empleado.getContraseña());

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);

        } catch (SQLException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
            throw e;
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            // La conexión se gestiona probablemente en otro lugar (DatabaseConnection)
        }
        return exito;
    }

    public static boolean actualizarEmpleado(Empleado empleado) throws SQLException {
        String sql = "UPDATE EMPLEADOS SET NOMBRE = ?, APELLIDOS = ?, CORREO = ?, TIPOEMPLEADO = ?, CONTRASEÑA = ? WHERE ID = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean exito = false;

        try {
            conn = DatabaseConnection.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellidos());
            pstmt.setString(3, empleado.getCorreo());
            pstmt.setString(4, empleado.getTipoEmpleado());
            pstmt.setString(5, empleado.getContraseña());
            pstmt.setInt(6, empleado.getId()); // Condición WHERE

            int filasAfectadas = pstmt.executeUpdate();
            exito = (filasAfectadas > 0);

        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
            throw e; // Re-lanza la excepción para que la ventana pueda manejarla
        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            // La conexión se gestiona probablemente en otro lugar (DatabaseConnection)
        }
        return exito;
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
