package Productos;

public class Juego_de_mesa extends Producto{

    private String editorial;
    private int Numero_jugadores;

        //Constructor para Juego de Mesa
    public Juego_de_mesa(String nombre, int precio,String tipo ,String editorial, int stock, int Numero_jugadores){
        super.Producto(nombre, precio, tipo, stock);
        this.editorial = editorial;
        this.Numero_jugadores = Numero_jugadores;
    }

        //Setters y getters
    public String getEditorial(){
        return this.editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumero_jugadores() {
        return Numero_jugadores;
    }

    public void setNumero_jugadores(int numero_jugadores) {
        Numero_jugadores = numero_jugadores;
    }
}
