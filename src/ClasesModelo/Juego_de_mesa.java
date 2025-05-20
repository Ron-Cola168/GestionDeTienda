package ClasesModelo;

public class Juego_de_mesa extends Producto{

    private String genero;
    private int Numero_jugadores;

        //Constructor para Juego de Mesa
    public Juego_de_mesa(int id, String nombre, int precio, int stock, String genero, int Numero_jugadores, int ventas){
        super(id, nombre, precio, stock, ventas);
        this.genero = genero;
        this.Numero_jugadores = Numero_jugadores;
    }

        //Setters y getters
    public String getEditorial(){
        return this.genero;
    }

    public void setEditorial(String editorial) {
        this.genero = genero;
    }

    public int getNumero_jugadores() {
        return Numero_jugadores;
    }

    public void setNumero_jugadores(int numero_jugadores) {
        Numero_jugadores = numero_jugadores;
    }
}
