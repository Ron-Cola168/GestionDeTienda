package ClasesModelo;

public class TCG extends Producto{

    String tipo;
    String juego;

    public TCG(int id,String nombre, int precio, int stock, int ventas, String tipo, String juego){
        super(id, nombre, precio, stock, ventas);
        this.tipo = tipo;
        this.juego = juego;
    }

    public String getTipo(){return this.tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
}
