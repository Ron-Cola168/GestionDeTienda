package ClasesDAO;

import ClasesModelo.TCG;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase de acceso a datos (DAO) para la entidad {@link TCG} (Tarjeta Coleccionable).
 * Proporciona métodos para interactuar con la tabla 'TCG' en la base de datos,
 * permitiendo obtener, buscar, insertar, eliminar y actualizar información de las cartas TCG.
 */
public class TCGDAO {

    /**
     * Obtiene todas las cartas TCG almacenadas en la base de datos.
     *
     * @return Una {@link List} de objetos {@link TCG}, donde cada objeto representa una carta TCG.
     * Si no hay cartas en la base de datos, la lista estará vacía.
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
     * Obtiene las 10 cartas TCG más vendidas, ordenadas por el número de ventas de forma descendente.
     *
     * @return Una {@link List} de los 10 objetos {@link TCG} más vendidos.
     * Si hay menos de 10 cartas, devolverá todas las disponibles ordenadas por ventas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static List<TCG> masVendidos() throws SQLException {
        List<TCG> tcgList = new ArrayList<>();
        String sql = "SELECT id, nombre, precio, stock, ventas, tipo, juego FROM TCG ORDER BY ventas DESC FETCH FIRST 10 ROWS ONLY"; // Sintaxis para obtener los primeros 10

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
     * Busca cartas TCG que coincidan con un juego y un tipo específicos.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param juego El nombre del juego de las cartas a buscar.
     * @param tipo  El tipo de carta a buscar (ej., criatura, hechizo).
     * @return Una {@link List} de objetos {@link TCG} que pertenecen al juego y tienen el tipo especificados.
     * Si no se encuentran cartas, la lista estará vacía.
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
     *
     * @param tcg El objeto {@link TCG} que contiene la información de la carta a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} en caso contrario.
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
     * Elimina una carta TCG de la base de datos basándose en su nombre exacto.
     *
     * @param nombre El nombre de la carta TCG a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
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
     * Actualiza la información de una carta TCG existente en la base de datos.
     * La búsqueda de la carta a actualizar se realiza por su nombre.
     *
     * @param tcg El objeto {@link TCG} con la información actualizada de la carta.
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
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
     * Obtiene una carta TCG de la base de datos por su nombre exacto.
     * Utiliza Streams para simplificar la búsqueda en la lista obtenida de la base de datos.
     *
     * @param nombreBuscar El nombre de la carta TCG a buscar.
     * @return El objeto {@link TCG} encontrado, o {@code null} si no se encuentra ninguna carta con ese nombre.
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