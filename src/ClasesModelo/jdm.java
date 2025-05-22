package ClasesModelo;

public class jdm extends Producto{

    private String genero;
    private int Numero_jugadores;

        //Constructor para Juego de Mesa
    public jdm(int id, String nombre, int precio, int stock, String genero, int Numero_jugadores, int ventas){
        super(id, nombre, precio, stock, ventas);
        this.genero = genero;
        this.Numero_jugadores = Numero_jugadores;
    }

        //Setters y getters
    public String getGenero() {return this.genero;}
    public void setGenero(String genero) {this.genero = genero;}
    public int getNumeroJugadores() {return this.Numero_jugadores;}
    public void setNumeroJugadores(int Numero_jugadores) {this.Numero_jugadores = Numero_jugadores;}
}
