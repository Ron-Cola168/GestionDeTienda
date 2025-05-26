package ClasesDAO;

import ClasesModelo.jdm;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) para la entidad {@link jdm} (Juego De Mesa).
 * Proporciona métodos para interactuar con la tabla 'juegos_mesa' en la base de datos,
 * permitiendo obtener, buscar, insertar, eliminar y actualizar información de los juegos de mesa.
 */
public class jdmDAO {

    /**
     * Obtiene una lista con todos los juegos de mesa almacenados en la base de datos.
     *
     * @return Una {@link List} de objetos {@link jdm}, donde cada objeto representa un juego de mesa.
     * Si no hay juegos en la base de datos, la lista estará vacía.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Busca un juego de mesa en la base de datos por su nombre exacto.
     *
     * @param nombre El nombre del juego de mesa a buscar.
     * @return Un objeto {@link jdm} si se encuentra un juego con ese nombre,
     * o {@code null} si no se encuentra ningún juego.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Inserta un nuevo juego de mesa en la base de datos.
     *
     * @param juego El objeto {@link jdm} que contiene la información del juego a insertar.
     * @return {@code true} si la inserción fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Elimina un juego de mesa de la base de datos basándose en su nombre.
     *
     * @param nombre El nombre del juego de mesa a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public static boolean eliminarJuego(String nombre) throws SQLException {
        String sql = "DELETE FROM juegos_mesa WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        }
    }

    /**
     * Actualiza la información de un juego de mesa existente en la base de datos.
     * La búsqueda del juego a actualizar se realiza por su nombre.
     *
     * @param juego El objeto {@link jdm} con la información actualizada del juego.
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Busca juegos de mesa en la base de datos por su género.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     *
     * @param genero El género de los juegos de mesa a buscar.
     * @return Una {@link List} de objetos {@link jdm} que pertenecen al género especificado.
     * Si no se encuentran juegos del género, la lista estará vacía.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Busca juegos de mesa en la base de datos por el número de jugadores que pueden participar.
     *
     * @param numJugadores El número de jugadores a buscar.
     * @return Una {@link List} de objetos {@link jdm} que admiten ese número de jugadores.
     * Si no se encuentran juegos para ese número de jugadores, la lista estará vacía.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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

    /**
     * Obtiene una lista de los 10 juegos de mesa más vendidos de la base de datos.
     * Los juegos se ordenan de mayor a menor número de ventas.
     *
     * @return Una {@link List} de objetos {@link jdm} con los 10 juegos más vendidos.
     * Si hay menos de 10 juegos, devolverá todos los disponibles ordenados por ventas.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
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