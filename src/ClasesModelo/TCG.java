package ClasesModelo;

/**
 * Representa una Tarjeta Coleccionable (TCG), que es un tipo específico de {@link Producto}.
 * Además de las propiedades básicas de un producto, una TCG tiene un tipo (ej., "criatura", "hechizo")
 * y pertenece a un juego específico (ej., "Magic: The Gathering", "Yu-Gi-Oh!").
 */
public class TCG extends Producto{

    private String tipo; // El tipo de la tarjeta coleccionable (ej., criatura, hechizo, objeto).
    private String juego; // El nombre del juego al que pertenece la tarjeta (ej., Magic, Pokémon).

    /**
     * Constructor para crear una nueva Tarjeta Coleccionable con todos sus detalles, incluyendo su ID.
     *
     * @param id     El identificador único del producto TCG.
     * @param nombre El nombre del producto TCG.
     * @param precio El precio del producto TCG.
     * @param stock  La cantidad disponible en stock del producto TCG.
     * @param ventas El número de ventas del producto TCG.
     * @param tipo   El tipo específico de la tarjeta coleccionable.
     * @param juego  El juego al que pertenece la tarjeta coleccionable.
     */
    public TCG(int id, String nombre, int precio, int stock, int ventas, String tipo, String juego){
        super(id, nombre, precio, stock, ventas);
        this.tipo = tipo;
        this.juego = juego;
    }

    /**
     * Constructor para crear una nueva Tarjeta Coleccionable sin especificar el ID (para inserción).
     *
     * @param nombre  El nombre del producto TCG.
     * @param precio  El precio del producto TCG.
     * @param stock   La cantidad disponible en stock del producto TCG.
     * @param ventas  El número de ventas del producto TCG.
     * @param tipo    El tipo específico de la tarjeta coleccionable.
     * @param juego   El juego al que pertenece la tarjeta coleccionable.
     */
    public TCG(String nombre, int precio, int stock, int ventas, String tipo, String juego) {
        super(nombre, precio, stock, ventas);
        this.tipo = tipo;
        this.juego = juego;
    }

    /**
     * Obtiene el tipo de la tarjeta coleccionable.
     *
     * @return El tipo de la tarjeta (ej., "criatura").
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * Establece el tipo de la tarjeta coleccionable.
     *
     * @param tipo El nuevo tipo para la tarjeta.
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre del juego al que pertenece la tarjeta coleccionable.
     *
     * @return El nombre del juego.
     */
    public String getJuego() {
        return juego;
    }

    /**
     * Establece el nombre del juego al que pertenece la tarjeta coleccionable.
     *
     * @param juego El nuevo nombre del juego.
     */
    public void setJuego(String juego) {
        this.juego = juego;
    }
}