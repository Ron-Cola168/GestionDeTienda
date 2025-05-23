package ClasesDAO;

import ClasesModelo.TCG;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TCGDAO {

    /**
     * Obtiene todas las cartas TCG de la base de datos.
     * @return Una lista de objetos TCG.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<TCG> obtenerTCGS() throws SQLException {
        List<TCG> tcgList = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock, ventas, tipo, juego FROM TCG"; // Especificamos las columnas

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tcgList.add(new TCG(
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
        return tcgList;
    }

    /**
     * Obtiene las 10 cartas TCG más vendidas.
     * @return Una lista de los 10 objetos TCG más vendidos.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<TCG> masVendidos() throws SQLException {
        List<TCG> tcgList = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock, ventas, tipo, juego FROM TCG ORDER BY ventas DESC FETCH FIRST 10 ROWS ONLY"; // Sintaxis más moderna para LIMIT

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                tcgList.add(new TCG(
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
        return tcgList;
    }

    /**
     * Busca cartas TCG por juego y tipo (sin distinguir mayúsculas/minúsculas).
     * @param juego El nombre del juego.
     * @param tipo El tipo de carta.
     * @return Una lista de objetos TCG que coinciden con el juego y el tipo.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<TCG> buscarPorJuegoYTipo(String juego, String tipo) throws SQLException {
        List<TCG> tcgList = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock, ventas, tipo, juego FROM TCG WHERE LOWER(juego) = LOWER(?) AND LOWER(tipo) = LOWER(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, juego);
            pstmt.setString(2, tipo);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    tcgList.add(new TCG(
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
        return tcgList;
    }

    /**
     * Inserta una nueva carta TCG en la base de datos.
     * @param tcg El objeto TCG a insertar.
     * @return true si la inserción fue exitosa, false en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static boolean insertarTCG(TCG tcg) throws SQLException {
        String sql = "INSERT INTO TCG (nombre, precio, stock, ventas, tipo, juego) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tcg.getNombre());
            pstmt.setInt(2, tcg.getPrecio());
            pstmt.setInt(3, tcg.getStock());
            pstmt.setInt(4, tcg.getVentas());
            pstmt.setString(5, tcg.getTipo());
            pstmt.setString(6, tcg.getJuego());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    /**
     * Elimina una carta TCG de la base de datos por su nombre.
     * @param nombre El nombre de la carta TCG a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static boolean eliminarTCG(String nombre) throws SQLException {
        String sql = "DELETE FROM TCG WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    /**
     * Actualiza la información de una carta TCG en la base de datos.
     * @param tcg El objeto TCG con la información actualizada.
     * @return true si la actualización fue exitosa, false en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static boolean actualizarTCG(TCG tcg) throws SQLException {
        String sql = "UPDATE TCG SET precio = ?, stock = ?, tipo = ?, juego = ? WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, tcg.getPrecio());
            pstmt.setInt(2, tcg.getStock());
            pstmt.setString(3, tcg.getTipo());
            pstmt.setString(4, tcg.getJuego());
            pstmt.setString(5, tcg.getNombre());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    /**
     * Obtiene una carta TCG por su nombre (usando Streams para simplificar).
     * @param nombreBuscar El nombre de la carta a buscar.
     * @return El objeto TCG encontrado, o null si no se encuentra.
     */
    public static TCG obtenerTCGPorNombre(String nombreBuscar) {
        try {
            return obtenerTCGS().stream()
                    .filter(tcg -> tcg.getNombre().equalsIgnoreCase(nombreBuscar))
                    .findFirst()
                    .orElse(null);
        } catch (SQLException ex) {
            System.err.println("Error al obtener TCG por nombre: " + ex.getMessage());
            return null;
        }
    }
}