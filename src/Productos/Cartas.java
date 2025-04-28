package Productos;

public class Cartas extends Producto{

    private String juego;

        //Constructor para Cartas
    public Cartas(String nombre, int precio, String tipo, int stock, String juego){
        super(nombre, precio, tipo, stock);
        this.juego = juego;
    }

        //Getters y setters
    public String getJuego(){
        return this.juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }


}
