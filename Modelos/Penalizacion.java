package Modelos;

public class Penalizacion {
    private int codigo;
    private Piloto piloto;
    private String fecha;
    private int sancion;

    public Penalizacion(int codigo, Piloto piloto, String fecha, int sancion) {
        this.codigo = codigo;
        this.piloto = piloto;
        this.fecha = fecha;
        this.sancion = sancion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSancion() {
        return sancion;
    }

    public void setSancion(int sancion) {
        this.sancion = sancion;
    }

    public String toString() {
        return "Codigo: " + codigo +
                " Piloto: " + piloto.getNombre() + " " + piloto.getApellido() +
                " Fecha: " + fecha +
                " Sancion: " + sancion;
    }
}
