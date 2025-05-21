package ClasesDAO;

import ClasesModelo.Juego_de_mesa;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Juego_de_mesaDAO {

    // Obtener todos los juegos
    public static List<Juego_de_mesa> obtenerTodosLosJuegos() throws SQLException {
        List<Juego_de_mesa> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                juegos.add(new Juego_de_mesa(
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
    public static Juego_de_mesa obtenerJuegoPorNombre(String nombre) throws SQLException {
        String sql = "SELECT * FROM juegos_mesa WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Juego_de_mesa(
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
    public static boolean insertarJuego(Juego_de_mesa juego) throws SQLException {
        String sql = "INSERT INTO juegos_mesa (nombre, precio, stock, genero, numero_jugadores, ventas) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, juego.getNombre());
            pstmt.setInt(2, juego.getPrecio());
            pstmt.setInt(3, juego.getStock());
            pstmt.setString(4, juego.getGenero()); // Nota: getEditorial() realmente obtiene el género
            pstmt.setInt(5, juego.getNumeroJugadores());
            pstmt.setInt(6, juego.getVentas());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Actualizar juego existente
    public static boolean actualizarJuego(Juego_de_mesa juego) throws SQLException {
        String sql = "UPDATE juegos_mesa SET nombre = ?, precio = ?, stock = ?, " +
                    "genero = ?, numero_jugadores = ?, ventas = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, juego.getNombre());
            pstmt.setInt(2, juego.getPrecio());
            pstmt.setInt(3, juego.getStock());
            pstmt.setString(4, juego.getGenero()); // Nota: getEditorial() realmente obtiene el género
            pstmt.setInt(5, juego.getNumeroJugadores());
            pstmt.setInt(6, juego.getVentas());
            pstmt.setInt(7, juego.getID());

            return pstmt.executeUpdate() > 0;
        }
    }

    // Eliminar juego
    public static boolean eliminarJuego(int id) throws SQLException {
        String sql = "DELETE FROM juegos_mesa WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        }
    }

    // Buscar juegos por género
    public static List<Juego_de_mesa> buscarJuegosPorGenero(String genero) throws SQLException {
        List<Juego_de_mesa> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa WHERE LOWER(genero) = LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, genero);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    juegos.add(new Juego_de_mesa(
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

    public static List<Juego_de_mesa> buscarJuegosPorNumJugadores(int numJugadores) throws SQLException {
        List<Juego_de_mesa> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos_mesa WHERE numero_jugadores = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numJugadores);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    juegos.add(new Juego_de_mesa(
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

    public static List<Juego_de_mesa> masVendidos() throws SQLException {
        List<Juego_de_mesa> juegos = new ArrayList<>();
        String sql = "SELECT * FROM (SELECT * FROM juegos_mesa ORDER BY ventas DESC) WHERE ROWNUM <= 10";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                juegos.add(new Juego_de_mesa(
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