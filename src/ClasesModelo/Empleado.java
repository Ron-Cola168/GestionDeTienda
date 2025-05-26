package ClasesModelo;

/**
 * Esta clase representa a un empleado de la tienda.
 * Guarda información sobre cada empleado, como su nombre, apellidos, correo electrónico,
 * su puesto en la tienda y su contraseña para acceder al sistema.
 */
public class Empleado {

    private  int id; // Un número único para identificar a cada empleado.
    private  String nombre; // El nombre del empleado.
    private  String apellidos; // Los apellidos del empleado.
    private  String correo; // El correo electrónico del empleado.
    private  String tipoEmpleado; // El tipo de empleado (por ejemplo, "vendedor", "administrador").
    private  String contrasenia; // La contraseña del empleado para iniciar sesión.

    /**
     * Constructor básico para crear un empleado. Se utiliza cuando no tenemos todos los detalles al principio.
     */
    public Empleado(){
    }

    /**
     * Constructor para crear un nuevo empleado para añadir a la base de datos.
     * No necesitamos especificar el ID, ya que la base de datos le asignará uno automáticamente.
     *
     * @param nombre        El nombre del empleado.
     * @param apellidos     Los apellidos del empleado.
     * @param tipoEmpleado  El puesto o tipo de empleado.
     * @param contrasenia   La contraseña del empleado.
     */
    public Empleado(String nombre, String apellidos, String tipoEmpleado, String contrasenia){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tipoEmpleado = tipoEmpleado;
        this.contrasenia = contrasenia;
    }

    /**
     * Constructor para crear un objeto Empleado cuando ya tenemos todos los detalles,
     * por ejemplo, al leer la información de la base de datos.
     *
     * @param id            El número único del empleado.
     * @param nombre        El nombre del empleado.
     * @param apellidos     Los apellidos del empleado.
     * @param correo        El correo electrónico del empleado.
     * @param tipoEmpleado  El puesto o tipo de empleado.
     * @param contrasenia   La contraseña del empleado.
     */
    public Empleado(int id,String nombre, String apellidos, String correo, String tipoEmpleado, String contrasenia){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipoEmpleado = tipoEmpleado;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el número de identificación único del empleado.
     *
     * @return El ID del empleado.
     */
    public  int getId() {
        return id;
    }

    /**
     * Permite cambiar o establecer el número de identificación único del empleado.
     *
     * @param id El nuevo ID para el empleado.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public  String getNombre() {
        return nombre;
    }

    /**
     * Permite cambiar o establecer el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return Los apellidos del empleado.
     */
    public  String getApellidos() {
        return apellidos;
    }

    /**
     * Permite cambiar o establecer los apellidos del empleado.
     *
     * @param apellidos Los nuevos apellidos del empleado.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return El correo electrónico del empleado.
     */
    public  String getCorreo() {
        return correo;
    }

    /**
     * Permite cambiar o establecer el correo electrónico del empleado.
     *
     * @param correo El nuevo correo electrónico del empleado.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el tipo de empleado (su cargo).
     *
     * @return El tipo de empleado.
     */
    public  String getTipoEmpleado() {
        return tipoEmpleado;
    }

    /**
     * Permite cambiar o establecer el tipo de empleado.
     *
     * @param tipoEmpleado El nuevo tipo de empleado.
     */
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    /**
     * Obtiene la contraseña del empleado.
     *
     * @return La contraseña del empleado.
     */
    public  String getContrasenia() {
        return contrasenia;
    }

    /**
     * Permite cambiar o establecer la contraseña del empleado.
     *
     * @param contrasenia La nueva contraseña del empleado.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Muestra la información principal del empleado en formato de texto.
     * Es útil para ver rápidamente los detalles de un objeto Empleado.
     *
     * @return Una cadena de texto con el ID, nombre, apellidos, correo y cargo del empleado.
     */
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