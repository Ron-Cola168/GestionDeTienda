package ClasesModelo;

public class TCG extends Producto{

    String tipo;
    String juego;

    public TCG(int id,String nombre, int precio, int stock, int ventas, String tipo, String juego){
        super(nombre, precio, stock, ventas);
        this.tipo = tipo;
        this.juego = juego;
    }

    public TCG(String nombre, int precio, int stock, int stock1, String tipo, String juego) {
        super(nombre, precio, stock, stock1);
        this.tipo = tipo;
        this.juego = juego;
    }

    public String getTipo(){return this.tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }
}
