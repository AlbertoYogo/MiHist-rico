package aparcamiento;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

	private double llegada;
	private int estancia;
	private Vehículo v;
	
	public Cliente(String dNI, String nombre, String apellidos, int edad, String direccion, String email,
			double llegada, int estancia, Vehículo v) {
		super(dNI, nombre, apellidos, edad, direccion, email);
		this.llegada = llegada;
		this.estancia = estancia;
		this.v = v;
	}
	
	public Cliente() {
		super();
		this.llegada=0;
		this.estancia=0;
		this.v=null;
	}


	public double getLlegada() {
		return llegada;
	}

	public void setLlegada(double llegada) {
		this.llegada = llegada;
	}

	public int getEstancia() {
		return estancia;
	}

	public void setEstancia(int estancia) {
		this.estancia = estancia;
	}

	public Vehículo getV() {
		return v;
	}

	public void setV(Vehículo v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "Cliente [llegada=" + llegada + ", estancia=" + estancia + ", v=" + v + ", DNI=" + DNI + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", direccion=" + direccion + ", email="
				+ email + "]";
	}
	
	
	public static void main(String[] args) {
		Moto m=new Moto("1234-ABC", "rojo", "mercedes", "alguno", "cualquiera", 3.7, "A");
		Cliente c=new Cliente("11111111A", "Alberto", "Lopez", 20, "Toledo", "comenius@gmail.com", 15.00, 4, m);
		System.out.println(c);
	}
	
	
}
