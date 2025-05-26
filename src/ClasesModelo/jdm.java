package ClasesModelo;

/**
 * Representa un Juego De Mesa (JDM), que es un tipo específico de {@link Producto}.
 * Además de las propiedades básicas de un producto, un JDM tiene un género (ej., estrategia, familiar)
 * y especifica el número de jugadores que pueden participar.
 */
public class jdm extends Producto{

    private String genero; // El género del juego de mesa (ej., estrategia, familiar, abstracto).
    private int Numero_jugadores; // El número de jugadores que pueden participar en el juego de mesa.

    /**
     * Constructor para crear un nuevo Juego De Mesa con todos sus detalles, incluyendo su ID.
     *
     * @param id              El identificador único del producto JDM.
     * @param nombre          El nombre del producto JDM.
     * @param precio          El precio del producto JDM.
     * @param stock           La cantidad disponible en stock del producto JDM.
     * @param genero          El género del juego de mesa.
     * @param Numero_jugadores El número de jugadores que pueden jugar.
     * @param ventas          El número de ventas del producto JDM.
     */
    public jdm(int id, String nombre, int precio, int stock, String genero, int Numero_jugadores, int ventas){
        super(id, nombre, precio, stock, ventas);
        this.genero = genero;
        this.Numero_jugadores = Numero_jugadores;
    }

    /**
     * Constructor para crear un nuevo Juego De Mesa sin especificar el ID (para inserción).
     *
     * @param nombre          El nombre del producto JDM.
     * @param precio          El precio del producto JDM.
     * @param stock           La cantidad disponible en stock del producto JDM.
     * @param genero          El género del juego de mesa.
     * @param Numero_jugadores El número de jugadores que pueden jugar.
     * @param ventas          El número de ventas del producto JDM.
     */
    public jdm(String nombre, int precio, int stock, String genero, int Numero_jugadores, int ventas){
        super(nombre, precio, stock, ventas);
        this.genero = genero;
        this.Numero_jugadores = Numero_jugadores;
    }

    /**
     * Obtiene el género del juego de mesa.
     *
     * @return El género del juego.
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Establece el género del juego de mesa.
     *
     * @param genero El nuevo género del juego.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el número de jugadores que pueden participar en el juego de mesa.
     *
     * @return El número de jugadores.
     */
    public int getNumeroJugadores() {
        return this.Numero_jugadores;
    }

    /**
     * Establece el número de jugadores que pueden participar en el juego de mesa.
     *
     * @param Numero_jugadores El nuevo número de jugadores.
     */
    public void setNumeroJugadores(int Numero_jugadores) {
        this.Numero_jugadores = Numero_jugadores;
    }
}