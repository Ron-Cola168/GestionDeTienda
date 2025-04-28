public class Empleado {

    private String nombre;
    private int numero_empleado;
    private String puesto;

        //Constructor para empleado
    public Empleado(String nombre, int numero_empleado, String puesto){
        this.nombre = nombre;
        this.numero_empleado = numero_empleado;
        this.puesto = puesto;
    }

        //Getters y setters
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_empleado(){
        return this.numero_empleado;
    }

    public void setNumero_empleado(int numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    public String getPuesto(){
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
