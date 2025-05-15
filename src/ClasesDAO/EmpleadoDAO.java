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

}
