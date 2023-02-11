package gestionAparcamiento;

import java.io.Serializable;

public class Coche extends Vehiculo implements Serializable {
    private int numeroPuertas;

    public Coche() {
        super();
        this.numeroPuertas = 4;
    }

    public Coche(String matricula, String color, String marca, String modelo, int numeroPuertas) {
        super(matricula, color, marca, modelo);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "numeroPuertas=" + numeroPuertas +
                ", matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
