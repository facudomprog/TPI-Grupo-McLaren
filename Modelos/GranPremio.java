package Modelos;

public class GranPremio {
    private int codigo;
    private String nombre;
    private String pais;
    private String ciudad;
    private int cantidadVueltas;
    private String fecha;

    public GranPremio(int codigo, String nombre, String pais, String ciudad, int cantidadVueltas, String fecha) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.cantidadVueltas = cantidadVueltas;
        this.fecha = fecha;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getCantidadVueltas() {
        return cantidadVueltas;
    }

    public void setCantidadVueltas(int cantidadVueltas) {
        this.cantidadVueltas = cantidadVueltas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String toString() {
        return "Codigo: " + codigo +
                " Nombre: " + nombre +
                " Pais: " + pais +
                " Ciudad: " + ciudad +
                " Cantidad De Vueltas: " + cantidadVueltas +
                " Fecha: " + fecha;
    }
}
