package Modelos;

public class Carrera {
    private int codigo;
    private GranPremio granPremio;
    private Piloto piloto;
    private int posicion;
    private String tiempo;

    public Carrera(int codigo, GranPremio granPremio, Piloto piloto, int posicion, String tiempo) {
        this.codigo = codigo;
        this.granPremio = granPremio;
        this.piloto = piloto;
        this.posicion = posicion;
        this.tiempo = tiempo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public GranPremio getGranPremio() {
        return granPremio;
    }

    public void setGranPremio(GranPremio granPremio) {
        this.granPremio = granPremio;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }


    public String toString() {
        return  "Codigo: " + codigo +
                " Gran Premio: " + granPremio +
                " Piloto: " + piloto.getNombre() + " " + piloto.getApellido() +
                " Posicion: " + posicion +
                " Tiempo: " + tiempo;
    }
}
