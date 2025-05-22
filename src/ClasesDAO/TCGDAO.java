package ClasesDAO;

import ClasesModelo.TCG;
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
                        rs.getString("tipo"),
                        rs.getString("descripcion"),
                        rs.getInt("stock"),
                        rs.getInt("ventas")
                ));
            }
        }
        return TCG;
    }
}
