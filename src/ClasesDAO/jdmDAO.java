package ClasesDAO;

import ClasesModelo.jdm;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdmDAO {

    // Obtener todos los juegos
    public static List<jdm> obtenerTodosLosJuegos() throws SQLException {
        List<jdm> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                juegos.add(new jdm(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("precio"),
                    rs.getInt("stock"),
                    rs.getString("genero"),
                    rs.getInt("numero_jugadores"),
                    rs.getInt("ventas")
                ));
            }
        }
        return juegos;
    }

    // Buscar juego por nombre
    public static jdm obtenerJuegoPorNombre(String nombre) throws SQLException {
        String sql = "SELECT * FROM juegos_mesa WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new jdm(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getString("genero"),
                        rs.getInt("numero_jugadores"),
                        rs.getInt("ventas")
                    );
                }
            }
        }
        return null;
    }

    // Insertar nuevo juego
    public static boolean insertarJuego(jdm juego) throws SQLException {
        String sql = "INSERT INTO juegos_mesa (nombre, precio, stock, genero, numero_Jugadores, ventas) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, juego.getNombre());
            pstmt.setDouble(2, juego.getPrecio());
            pstmt.setInt(3, juego.getStock());
            pstmt.setString(4, juego.getGenero());
            pstmt.setInt(5, juego.getNumeroJugadores());
            pstmt.setInt(6, juego.getVentas());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    // Eliminar juego
    public static boolean eliminarJuego(String nombre) throws SQLException {
        String sql = "DELETE FROM juegos_mesa WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    public static boolean actualizarJuego(jdm juego) throws SQLException {
        String sql = "UPDATE juegos_mesa SET precio = ?, stock = ?, genero = ?, numero_Jugadores = ? WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, juego.getPrecio());
            pstmt.setInt(2, juego.getStock());
            pstmt.setString(3, juego.getGenero());
            pstmt.setInt(4, juego.getNumeroJugadores());
            pstmt.setString(5, juego.getNombre());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }


    // Buscar juegos por género
    public static List<jdm> buscarJuegosPorGenero(String genero) throws SQLException {
        List<jdm> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa WHERE LOWER(genero) = LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, genero);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    juegos.add(new jdm(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getString("genero"),
                        rs.getInt("numero_jugadores"),
                        rs.getInt("ventas")
                    ));
                }
            }
        }
        return juegos;
    }

    public static List<jdm> buscarJuegosPorNumJugadores(int numJugadores) throws SQLException {
        List<jdm> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa WHERE numero_jugadores = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numJugadores);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    juegos.add(new jdm(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getString("genero"),
                        rs.getInt("numero_jugadores"),
                        rs.getInt("ventas")
                    ));
                }
            }
        }
        return juegos;
    }

    public static List<jdm> masVendidos() throws SQLException {
        List<jdm> juegos = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT * FROM juegos_mesa ORDER BY ventas DESC) WHERE ROWNUM <= 10";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                juegos.add(new jdm(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("stock"),
                        rs.getString("genero"),
                        rs.getInt("numero_jugadores"),
                        rs.getInt("ventas")
                ));
            }
        }
        return juegos;
    }
}