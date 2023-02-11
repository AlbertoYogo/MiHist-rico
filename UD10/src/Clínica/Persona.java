package Clínica;

public abstract class Persona{

	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected int teléfono;
	
	public Persona(String dNI, String nombre, String apellidos, int teléfono) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.teléfono = teléfono;
	}
	
	public Persona() {
		this.DNI="";
		this.nombre="";
		this.apellidos="";
		this.teléfono=0;
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

	public int getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(int teléfono) {
		this.teléfono = teléfono;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", teléfono=" + teléfono
				+ "]";
	}
	
	
}
