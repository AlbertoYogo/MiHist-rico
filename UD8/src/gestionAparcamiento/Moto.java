package gestionAparcamiento;

import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {
    private String tipo;
    private int cilindrada;
    private String carnet;

    public Moto() {
        super();
        this.tipo = "";
        this.cilindrada = 0;
        this.carnet = "";
    }

    public Moto(String matricula, String color, String marca, String modelo, String tipo, int cilindrada, String carnet) {
        super(matricula, color, marca, modelo);
        this.tipo = tipo;
        this.cilindrada = cilindrada;
        this.carnet = carnet;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "tipo='" + tipo + '\'' +
                ", cilindrada=" + cilindrada +
                ", carnet='" + carnet + '\'' +
                ", matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
