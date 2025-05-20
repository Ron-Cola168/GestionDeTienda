package ClasesModelo;

public class Producto {

    private int ID;
    private String nombre;
    private int precio = 0;
    private int stock;
    private int ventas;

        //Constructor para Productos
    public Producto(int id, String nombre, int precio, int stock, int ventas){
        this.ID = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.ventas = ventas;

    };


        //Getters y setters
    public int getID(){return this.ID;}

    public void setID(int ID){this.ID = ID;}

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio(){
        return this.precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVentas(){
        return this.ventas;
    }

    public void setVentas(int ventas){
        this.ventas = ventas;
    }
}
