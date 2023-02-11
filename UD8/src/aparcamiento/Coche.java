package aparcamiento;

import java.io.Serializable;

public class Coche extends Vehículo implements Serializable {

	private int puertas;

	public Coche(String matricula, String color, String marca, String modelo, int puertas) {
		super(matricula, color, marca, modelo);
		this.puertas = puertas;
	}
	
	public Coche() {
		super();
		this.puertas=0;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	@Override
	public String toString() {
		return "Coche [puertas=" + puertas + ", matricula=" + matricula + ", color=" + color + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
	}
	
	
}
