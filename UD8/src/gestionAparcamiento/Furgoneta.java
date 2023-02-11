package gestionAparcamiento;

import java.io.Serializable;

public class Furgoneta extends Vehiculo implements Serializable {
    private int capacidad;

    public Furgoneta() {
        super();
        this.capacidad = 0;
    }

    public Furgoneta(String matricula, String color, String marca, String modelo, int capacidad) {
        super(matricula, color, marca, modelo);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Furgoneta{" +
                "capacidad=" + capacidad +
                ", matricula='" + matricula + '\'' +
                ", color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
