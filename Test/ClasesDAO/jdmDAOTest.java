package ClasesDAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.SQLException;
import java.util.List;
import ClasesModelo.jdm;

class jdmDAOTest {
    
    private static jdm juegoTest;

    @BeforeAll
    static void setUpClass() {
        // Juego de prueba con valores válidos
        juegoTest = new jdm(
            0, // El ID se generará automáticamente
            "Test Game",
            29,
            10,
            "Estrategia",
            4,
            0
        );
    }

    @Test
    void obtenerTodosLosJuegos() {
        assertDoesNotThrow(() -> {
            List<jdm> juegos = jdmDAO.obtenerTodosLosJuegos();
            assertNotNull(juegos, "La lista de juegos no debería ser null");
        }, "Debería obtener la lista de juegos sin lanzar excepciones");
    }

    @Test
    void obtenerJuegoPorNombre() {
        assertDoesNotThrow(() -> {
            // Primero insertamos el juego de prueba
            jdmDAO.insertarJuego(juegoTest);
            
            // Luego intentamos recuperarlo
            jdm juego = jdmDAO.obtenerJuegoPorNombre("Test Game");
            assertNotNull(juego, "El juego recuperado no debería ser null");
            assertEquals("Test Game", juego.getNombre());
            assertEquals("Estrategia", juego.getGenero());
            
            // Limpieza
            jdmDAO.eliminarJuego("Test Game");
        }, "Debería obtener el juego por nombre sin lanzar excepciones");
    }

    @Test
    void insertarJuego() {
        assertDoesNotThrow(() -> {
            boolean resultado = jdmDAO.insertarJuego(juegoTest);
            assertTrue(resultado, "La inserción debería ser exitosa");
            
            // Verificar que el juego se insertó correctamente
            jdm juegoInsertado = jdmDAO.obtenerJuegoPorNombre("Test Game");
            assertNotNull(juegoInsertado);
            assertEquals(juegoTest.getNombre(), juegoInsertado.getNombre());
            assertEquals(juegoTest.getPrecio(), juegoInsertado.getPrecio());
            
            // Limpieza
            jdmDAO.eliminarJuego("Test Game");
        }, "Debería insertar el juego sin lanzar excepciones");
    }

    @Test
    void eliminarJuego() {
        assertDoesNotThrow(() -> {
            // Primero insertamos el juego
            jdmDAO.insertarJuego(juegoTest);
            
            // Luego lo eliminamos
            boolean resultado = jdmDAO.eliminarJuego("Test Game");
            assertTrue(resultado, "La eliminación debería ser exitosa");
            
            // Verificamos que ya no existe
            jdm juegoEliminado = jdmDAO.obtenerJuegoPorNombre("Test Game");
            assertNull(juegoEliminado, "El juego debería haber sido eliminado");
        }, "Debería eliminar el juego sin lanzar excepciones");
    }

    @Test
    void actualizarJuego() {
        assertDoesNotThrow(() -> {
            // Insertamos el juego primero
            jdmDAO.insertarJuego(juegoTest);
            
            // Modificamos algunos valores
            juegoTest.setPrecio(39);
            juegoTest.setStock(20);
            
            // Actualizamos
            boolean resultado = jdmDAO.actualizarJuego(juegoTest);
            assertTrue(resultado, "La actualización debería ser exitosa");
            
            // Verificamos los cambios
            jdm juegoActualizado = jdmDAO.obtenerJuegoPorNombre("Test Game");
            assertNotNull(juegoActualizado);
            assertEquals(39, juegoActualizado.getPrecio());
            assertEquals(20, juegoActualizado.getStock());
            
            // Limpieza
            jdmDAO.eliminarJuego("Test Game");
        }, "Debería actualizar el juego sin lanzar excepciones");
    }

    @Test
    void buscarJuegosPorGenero() {
        assertDoesNotThrow(() -> {
            // Insertamos el juego de prueba
            jdmDAO.insertarJuego(juegoTest);
            
            List<jdm> juegos = jdmDAO.buscarJuegosPorGenero("Estrategia");
            assertNotNull(juegos, "La lista de juegos no debería ser null");
            assertFalse(juegos.isEmpty(), "Debería encontrar al menos un juego");
            assertTrue(juegos.stream().allMatch(j -> j.getGenero().equalsIgnoreCase("Estrategia")),
                    "Todos los juegos deberían ser del género Estrategia");
            
            // Limpieza
            jdmDAO.eliminarJuego("Test Game");
        }, "Debería buscar juegos por género sin lanzar excepciones");
    }

    @Test
    void buscarJuegosPorNumJugadores() {
        assertDoesNotThrow(() -> {
            // Insertamos el juego de prueba
            jdmDAO.insertarJuego(juegoTest);
            
            List<jdm> juegos = jdmDAO.buscarJuegosPorNumJugadores(4);
            assertNotNull(juegos, "La lista de juegos no debería ser null");
            assertFalse(juegos.isEmpty(), "Debería encontrar al menos un juego");
            assertTrue(juegos.stream().allMatch(j -> j.getNumeroJugadores() == 4),
                    "Todos los juegos deberían ser para 4 jugadores");
            
            // Limpieza
            jdmDAO.eliminarJuego("Test Game");
        }, "Debería buscar juegos por número de jugadores sin lanzar excepciones");
    }

    @Test
    void masVendidos() {
        assertDoesNotThrow(() -> {
            List<jdm> juegos = jdmDAO.masVendidos();
            assertNotNull(juegos, "La lista de juegos no debería ser null");
            
            // Verificar que los juegos estén ordenados por ventas
            if (juegos.size() > 1) {
                for (int i = 0; i < juegos.size() - 1; i++) {
                    assertTrue(juegos.get(i).getVentas() >= juegos.get(i + 1).getVentas(),
                            "Los juegos deberían estar ordenados por ventas de mayor a menor");
                }
            }
        }, "Debería obtener los juegos más vendidos sin lanzar excepciones");
    }
}