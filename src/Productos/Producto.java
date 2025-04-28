package Productos;

public class Producto {

    private String nombre;
    private int precio = 0;
    private String tipo;
    private int stock;

        //Constructor para Productos
    public void Producto(String nombre, int precio, String tipo, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.stock = stock;
    };


        //Getters y setters
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

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStock(){
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
