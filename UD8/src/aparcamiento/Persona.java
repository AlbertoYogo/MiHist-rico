package aparcamiento;

import java.io.Serializable;

public abstract class Persona implements Serializable{
	
	protected String DNI;
	protected String nombre;
	protected String apellidos;
	protected int edad;
	protected String direccion;
	protected String email;
	
	public Persona(String dNI, String nombre, String apellidos, int edad, String direccion, String email) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.direccion = direccion;
		this.email = email;
	}
	
	public Persona() {
		this.DNI="";
		this.nombre="";
		this.apellidos="";
		this.edad=0;
		this.direccion="";
		this.email="";
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", direccion=" + direccion + ", email=" + email + "]";
	}
	
	boolean valida(String cadena) {
		char[] letras= {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		int prueba=Integer.parseInt(cadena.substring(0, 6));
		prueba=prueba/23;
		
		if (cadena.matches("[0-9]{8}[A-Z]{1}")) {
			if(cadena.charAt(7)==letras[prueba]) {
				return true;
			}
		}
		return false;
	}
}
