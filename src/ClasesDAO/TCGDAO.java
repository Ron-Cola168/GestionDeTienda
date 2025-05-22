package ClasesDAO;

import ClasesModelo.TCG;
import ClasesModelo.jdm;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TCGDAO {

    public static List<TCG> obtenerTCGS() throws SQLException {
        List<TCG> TCG = new ArrayList<>();
        String sql = "SELECT * FROM TCG";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TCG.add(new TCG(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getInt("ventas"),
                        rs.getString("tipo"),
                        rs.getString("juego")
                ));
            }
        }
        return TCG;
    }

    public static List<TCG> masVendidos() throws SQLException {
        List<TCG> TCG = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT * FROM TCG ORDER BY ventas DESC) WHERE ROWNUM <= 10";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TCG.add(new TCG(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getInt("ventas"),
                        rs.getString("tipo"),
                        rs.getString("juego")
                ));
            }
        }
        return TCG;
    }
}
