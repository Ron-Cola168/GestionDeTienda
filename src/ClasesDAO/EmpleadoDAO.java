package ClasesDAO;

import ClasesModelo.Empleado;
import util.DatabaseConnection;

import javax.swing.*;
import java.sql.*;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) para la entidad Empleado.
 * Proporciona métodos para interactuar con la tabla 'empleados' en la base de datos.
 */
public class EmpleadoDAO {

    /**
     * Autentica a un empleado en la base de datos utilizando su correo electrónico y contraseña.
     *
     * @param correo       El campo de texto con el correo electrónico del empleado.
     * @param contrasenia   El campo de contraseña con la contraseña del empleado.
     * @return Un objeto {@link Empleado} si la autenticación es exitosa, {@code null} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static Empleado autenticarEmpleado(JTextField correo, JPasswordField contrasenia) throws SQLException {
        Empleado empleado = null;
        String sql = "SELECT id, nombre, apellidos, correo, contraseña, tipoempleado " +
                "FROM empleados WHERE correo = ? AND contraseña = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, correo.getText());
            pstmt.setString(2, new String(contrasenia.getPassword()));

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

    /**
     * Inserta un nuevo empleado en la base de datos.
     *
     * @param empleado El objeto {@link Empleado} a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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
            pstmt.setString(4, empleado.getContrasenia());

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

    /**
     * Actualiza la información de un empleado existente en la base de datos.
     *
     * @param empleado El objeto {@link Empleado} con la información actualizada. El ID del empleado se utiliza para identificar el registro a actualizar.
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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
            pstmt.setString(5, empleado.getContrasenia());
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

    /**
     * Busca un empleado en la base de datos por su ID.
     *
     * @param id El ID del empleado a buscar.
     * @return Un objeto {@link Empleado} si se encuentra, {@code null} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Elimina un empleado de la base de datos por su ID.
     *
     * @param id El ID del empleado a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static boolean eliminarEmpleado(int id) throws SQLException {
        String sql = "DELETE FROM empleados WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }

    /**
     * Obtiene una lista de todos los empleados de la base de datos.
     *
     * @return Una {@link List} de objetos {@link Empleado}.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<Empleado> obtenerTodosLosEmpleados() throws SQLException {
        String sql = "SELECT id, nombre, apellidos, correo, tipoempleado, contraseña FROM empleados";

        List<Empleado> empleados = new java.util.ArrayList<>();

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