package ClasesModelo;

/**
 * Representa un producto genérico que se vende en la tienda.
 * Contiene información básica sobre cualquier producto, como su ID, nombre, precio,
 * la cantidad disponible en stock y el número de ventas.
 */
public class Producto {

    private int ID; // Un número único para identificar cada producto.
    private String nombre; // El nombre del producto.
    private int precio = 0; // El precio del producto en unidades monetarias. Inicializado a 0.
    private int stock; // La cantidad de este producto que hay disponible en la tienda.
    private int ventas; // El número total de veces que se ha vendido este producto.

    /**
     * Constructor para crear un nuevo producto con todos sus detalles, incluyendo el ID.
     * Se utiliza cuando ya se conoce el ID del producto (por ejemplo, al leer de la base de datos).
     *
     * @param id     El identificador único del producto.
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param stock  La cantidad disponible en stock.
     * @param ventas El número de ventas del producto.
     */
    public Producto(int id, String nombre, int precio, int stock, int ventas){
        this.ID = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.ventas = ventas;
    }

    /**
     * Constructor para crear un nuevo producto sin especificar el ID.
     * Se utiliza al crear un nuevo producto que aún no tiene un ID asignado (por ejemplo, antes de guardarlo en la base de datos).
     *
     * @param nombre El nombre del producto.
     * @param precio El precio del producto.
     * @param stock  La cantidad disponible en stock.
     * @param ventas El número de ventas del producto.
     */
    public Producto(String nombre, int precio, int stock, int ventas){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.ventas = ventas;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return El ID del producto.
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param ID El nuevo ID del producto.
     */
    public void setID(int ID){
        this.ID = ID;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public int getPrecio(){
        return this.precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la cantidad disponible en stock del producto.
     *
     * @return La cantidad en stock.
     */
    public int getStock(){
        return this.stock;
    }

    /**
     * Establece la cantidad disponible en stock del producto.
     *
     * @param stock La nueva cantidad en stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Obtiene el número de ventas del producto.
     *
     * @return El número de ventas.
     */
    public int getVentas(){
        return this.ventas;
    }

    /**
     * Establece el número de ventas del producto.
     *
     * @param ventas El nuevo número de ventas.
     */
    public void setVentas(int ventas){
        this.ventas = ventas;
    }
}