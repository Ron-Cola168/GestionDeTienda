package ClasesDAO;

import ClasesModelo.TCG;
import ClasesModelo.jdm;
import util.DatabaseConnection;

import java.sql.*;
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
public static List<TCG> buscarPorJuegoYTipo(String juego, String tipo) throws SQLException {
    List<TCG> tcgs = new ArrayList<>();
    String sql = "SELECT * FROM tcg WHERE LOWER(juego) = LOWER(?) AND LOWER(tipo) = LOWER(?)";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, juego);
        pstmt.setString(2, tipo);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                tcgs.add(new TCG(
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
    }
    return tcgs;
}
}