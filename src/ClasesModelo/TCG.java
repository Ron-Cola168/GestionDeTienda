package ClasesModelo;

public class TCG extends Producto{

    String tipo;
    String descripcion;

    public TCG(int id, String nombre, int precio, String tipo, String descripcion, int stock, int ventas){
        super(id, nombre, precio, stock, ventas);
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getTipo(){return this.tipo;}
    public void setTipo(String tipo){this.tipo = tipo;}
    public String getDescripcion(){return this.descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}
}
