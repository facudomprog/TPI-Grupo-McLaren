package Modelos;

public class Equipo {
    private int codigo;
    private String nombre;
    private String nacionalidad;
    private Monoplaza monoplaza;

    public Equipo(int codigo, String nombre, String nacionalidad, Monoplaza monoplaza) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.monoplaza = monoplaza;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Monoplaza getMonoplaza() {
        return monoplaza;
    }

    public void setMonoplaza(Monoplaza monoplaza) {
        this.monoplaza = monoplaza;
    }

    public String toString() {
        return   "Codigo: " + codigo +
                " Nombre: " + nombre +
                " Nacionalidad: " + nacionalidad +
                " Monoplaza: " + monoplaza;
    }
}
