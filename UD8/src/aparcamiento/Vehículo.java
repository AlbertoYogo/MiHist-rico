package aparcamiento;

import java.io.Serializable;

public abstract class Vehículo implements Serializable {

	protected String matricula;
	protected String color;
	protected String marca;
	protected String modelo;
	
	
	
	
	public Vehículo(String matricula, String color, String marca, String modelo) {
		super();
		if (valida(matricula)) {
			this.matricula=matricula;
		}
		else {
			this.matricula="";
		}
		this.color = color;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public Vehículo() {
		this.matricula="";
		this.color="";
		this.marca="";
		this.modelo="";
	}


	boolean valida(String cadena) {
		
		if(cadena.matches("[0-9]{4}-[A-Z]{3}")) {
			return true;
		}
		else {
			return false;
		}

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Vehículo [matricula=" + matricula + ", color=" + color + ", marca=" + marca + ", modelo=" + modelo
				+ "]";
	}
	
	
}
