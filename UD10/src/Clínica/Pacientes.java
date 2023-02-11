package Clínica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Pacientes extends Persona {
	
	private float peso;
	private int edad;
	private String cita;
	private String historia;
	
	public Pacientes(String dNI, String nombre, String apellidos, int teléfono, float peso, int edad, String cita,
			String historia) {
		super(dNI, nombre, apellidos, teléfono);
		this.peso = peso;
		this.edad = edad;
		this.cita = cita;
		this.historia = historia;
	}

	public Pacientes() {
		super();
		this.peso=0;
		this.edad=0;
		this.cita="";
		this.historia="";
	}
	
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCita() {
		return cita;
	}

	public void setCita(String cita) {
		this.cita = cita;
	}

	public String getHistoria() {
		return historia;
	}

	public void setHistoria(String historia) {
		this.historia = historia;
	}

	@Override
	public String toString() {
		return "Pacientes [peso=" + peso + ", edad=" + edad + ", cita=" + cita + ", historia=" + historia
				+ ", toString()=" + super.toString() + "]";
	}

	
	public void GuardarHistoria() {
		String filename;
		filename="Historia"+this.DNI+".txt";
		File fichero=new File(filename);
		try {
			PrintWriter salida=new PrintWriter(fichero);
			salida.println(this.historia);
			
			salida.flush();
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		Profesionales pro=new Profesionales("1234567A", "Alberto", "Lopez", 678392321, "Cirugia", Profesionales.MAÑANA);
		System.out.println(pro);
		/*int a=2;
		int b=4;
		b=++a;
		System.out.println(b);*/
	}


	
}
