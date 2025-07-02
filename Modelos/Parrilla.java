package Modelos;

public class Parrilla {
    private int codigo;
    private int posicion;
    private Piloto piloto;
    private  GranPremio granPremio;

    public Parrilla(int codigo, int posicion, Piloto piloto, GranPremio granPremio) {
        this.codigo = codigo;
        this.posicion = posicion;
        this.piloto = piloto;
        this.granPremio = granPremio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public GranPremio getGranPremio() {
        return granPremio;
    }

    public void setGranPremio(GranPremio granPremio) {
        this.granPremio = granPremio;
    }


    public String toString() {
        return "Codigo: " + codigo +
                " Posicion: " + posicion +
                " Piloto: " + piloto.getNombre() + " " + piloto.getApellido() +
                " Gran Premio: " + granPremio;
    }
}
