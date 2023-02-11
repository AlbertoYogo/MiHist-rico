package aparcamiento;

import java.io.Serializable;

public class Furgoneta extends Vehículo implements Serializable{
	
	private int capacidad;

	public Furgoneta(String matricula, String color, String marca, String modelo, int capacidad) {
		super(matricula, color, marca, modelo);
		this.capacidad = capacidad;
	}
	
	public Furgoneta() {
		super();
		this.capacidad=0;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Furgoneta [capacidad=" + capacidad + "]";
	}
	
	
}
