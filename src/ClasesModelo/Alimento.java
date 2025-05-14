package ClasesModelo;

public class Alimento extends Producto{

    private boolean esFrio;

        //Constructor para Alimentos
    public Alimento(String nombre, int precio, String tipo,int stock, boolean esFrio){
        super(nombre, precio, tipo, stock);
        this.esFrio = esFrio;
    }

        //Getters y setters
    public boolean isEsFrio() {
        return esFrio;
    }

    public void setEsFrio(boolean esFrio) {
        this.esFrio = esFrio;
    }
}
