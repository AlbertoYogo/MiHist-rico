package Cl�nica;

public abstract class Persona{

	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected int tel�fono;
	
	public Persona(String dNI, String nombre, String apellidos, int tel�fono) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tel�fono = tel�fono;
	}
	
	public Persona() {
		this.DNI="";
		this.nombre="";
		this.apellidos="";
		this.tel�fono=0;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTel�fono() {
		return tel�fono;
	}

	public void setTel�fono(int tel�fono) {
		this.tel�fono = tel�fono;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", tel�fono=" + tel�fono
				+ "]";
	}
	
	
}
