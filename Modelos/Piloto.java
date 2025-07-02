package Modelos;

public class Piloto {
    private int codigo;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private Equipo equipo;

    public Piloto(int codigo, String nombre, String apellido, String fechaNacimiento, String nacionalidad, Equipo equipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.equipo = equipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String toString() {
        return "Codigo: " + codigo +
                " Nombre: " + nombre +
                " Apellido: " + apellido +
                " Fecha De Nacimiento: " + fechaNacimiento +
                " Nacionalidad: " + nacionalidad +
                " Equipo: " + equipo;
    }
}
