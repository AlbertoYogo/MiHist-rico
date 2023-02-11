package alumnos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Correo {
	private String NombreAlumno;
	private String correo;
	
	
	public Correo() {
		this.NombreAlumno="";
		this.correo="";
	}
	
	public Correo(String nombreAlumno, String correo) {
		super();
		NombreAlumno = nombreAlumno;
		this.correo = correo;
	}
	
	
	public String getNombreAlumno() {
		return NombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		NombreAlumno = nombreAlumno;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	@Override
	public String toString() {
		return "Correo [NombreAlumno=" + NombreAlumno + ", correo=" + correo + "]";
	}
	
	//Dado el nombre del alumno crea su correo del IES Ribera del Tajo
	public String generarCorreo(String cadena) {
		String nombre="";
		String apellido1="";
		String linea[];
		cadena=cadena.toLowerCase();
		linea=cadena.split(",");
		nombre=linea[1].trim();
		//Quitamos las tildes
		nombre=nombre.replace("á", "a");
		nombre=nombre.replace("é", "e");
		nombre=nombre.replace("í","i");
		nombre=nombre.replace("ó", "o");
		nombre=nombre.replace("ú", "u");
		nombre=nombre.replace("à", "a");
		nombre=nombre.replace("è", "e");
		nombre=nombre.replace("è","i");
		nombre=nombre.replace("ò", "o");
		nombre=nombre.replace("ù", "u");
		
		linea=cadena.split(" ");
		apellido1=linea[0].trim();
		
		apellido1=apellido1.replace("á", "a");
		apellido1=apellido1.replace("é", "e");
		apellido1=apellido1.replace("í","i");
		apellido1=apellido1.replace("ó", "o");
		apellido1=apellido1.replace("ú", "u");
		apellido1=apellido1.replace("à", "a");
		apellido1=apellido1.replace("è", "e");
		apellido1=apellido1.replace("è","i");
		apellido1=apellido1.replace("ò", "o");
		apellido1=apellido1.replace("ù", "u");
		return "dam1_"+nombre.replace(" ", "")+apellido1+"@riberadeltajo.es";
	}
	
	
	public ArrayList<Correo> leerAlumnos() {
		ArrayList<Correo> correos=new ArrayList<>();
		File alumnos= new File("AlumnosDAM.csv");
		String nombre[];
		try {
			Scanner entrada=new Scanner(alumnos);
			String correo=entrada.nextLine();
			correo=entrada.nextLine();
			correo=entrada.nextLine();
			correo=entrada.nextLine();
			correo=entrada.nextLine();
			
			do {
				
				correo=entrada.nextLine();
				nombre=correo.split(";");
				this.setNombreAlumno(nombre[0]);
				this.setCorreo(this.generarCorreo(this.getNombreAlumno()));
				correos.add(new Correo(this.getNombreAlumno(), this.getCorreo()));
				
			}while(entrada.hasNext());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return correos;
	}
	
	public static void main(String[] args) {
		File prueba=new File("correos.txt");
		try {
			PrintWriter salida=new PrintWriter(prueba);
			
			ArrayList<Correo> correos=new ArrayList<>();
			Correo c=new Correo();
			correos=c.leerAlumnos();
			for (Correo co: correos) {
				salida.println(co.getNombreAlumno()+"  "+co.getCorreo());
			}
			salida.flush();
			salida.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
