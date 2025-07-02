package Modelos;

public class Monoplaza {
    private int codigo;
    private String modelo;
    private double peso;
    private  int potencia;
    private int velocidad;


    public Monoplaza(int codigo, String modelo, double peso, int potencia, int velocidad) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.peso = peso;
        this.potencia = potencia;
        this.velocidad = velocidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String toString() {
        return "Codigo: " + codigo +
                " Modelo: " + modelo +
                " Peso: " + peso +
                " Potencia: " + potencia +
                " Velocidad: " + velocidad;
    }
}
