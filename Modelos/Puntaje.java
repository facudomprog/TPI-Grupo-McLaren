package Modelos;

public class Puntaje {
    private int codigo;
    private Piloto piloto;
    private int puntos;

    public Puntaje(int codigo, Piloto piloto, int puntos) {
        this.codigo = codigo;
        this.piloto = piloto;
        this.puntos = puntos;
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

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String toString() {
        return "Codigo: " + codigo +
                " Piloto: " + piloto.getNombre() + " " + piloto.getApellido() +
                " Puntos: " + puntos;
    }
}
