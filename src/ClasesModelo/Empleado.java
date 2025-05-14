package ClasesModelo;

public class Empleado {

    private static int id;
    private static String nombre;
    private static String apellidos;
    private static String correo;
    private static String tipoEmpleado;
    private static String contraseña;

    /**Constructores**/
    public Empleado(){
    }

    /**Constructor solo para INSERTS**/
    public Empleado(String nombre, String apellidos, String tipoEmpleado, String contraseña){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoEmpleado = tipoEmpleado;
        this.contraseña = contraseña;
    }

    /**Constructor solo para consultas y actualizaciones**/
    public Empleado(int id,String nombre, String apellidos, String correo, String tipoEmpleado, String contraseña){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipoEmpleado = tipoEmpleado;
        this.contraseña = contraseña;
    }

    /**Getters y Setters**/
    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public static String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public static String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public static String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**ToString**/
    @Override
    public String toString() {
        return "Persona{" +
                "id =" + this.id +
                ", nombre ='" + this.nombre + '\'' +
                ", apellido ='" + this.apellidos + '\'' +
                ", email ='" + this.correo + '\'' +
                ", Cargo ='" + this.tipoEmpleado + '\'' +
                '}';
    }
}
