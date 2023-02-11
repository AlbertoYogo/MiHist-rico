package Matriculas;

import java.util.LinkedList;
import java.util.Scanner;

public class Clase {
	private LinkedList<Alumno> alumnosMatriculados;
	
	public Clase() {
		this.alumnosMatriculados= new LinkedList<>();
	}

	public LinkedList<Alumno> getAlumnosMatriculados() {
		return alumnosMatriculados;
	}

	public void setAlumnosMatriculados(LinkedList<Alumno> alumnosMatriculados) {
		this.alumnosMatriculados = alumnosMatriculados;
	}
	
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		Clase c =new Clase();
		int opcion=0;
		String DNI;
		
		while(opcion!=5) {
			System.out.println("1) Matricular alumno");
			System.out.println("2) Borrar alumno matriculado con dni");
			System.out.println("3) Mostrar ultimo alumno matriculado");
			System.out.println("4) Mostrar alumnos matriculados");
			System.out.println("5) Salir");
			System.out.println("Elige una opción:");
			opcion= Sc.nextInt();
			
			switch (opcion) {
			case 1: System.out.println("Nombre");
				String nombre=Sc.next();
				System.out.println("email");
				String email=Sc.next();
				System.out.println("DNI");
				DNI=Sc.next();
				System.out.println("Clave");
				String clave=Sc.next();
				Alumno a=new Alumno(clave, DNI, email, nombre);
				c.getAlumnosMatriculados().add(a);
				break;
			case 2: 
				System.out.println("DNI");
				DNI=Sc.next();
				for (int i = 0; i < c.getAlumnosMatriculados().size(); i++) {
				if (c.getAlumnosMatriculados().get(i).getDni().equals(DNI)) {
					c.getAlumnosMatriculados().remove(i);
				}
			}
				break;
			case 3: System.out.println(c.getAlumnosMatriculados().getLast());
				break;
			case 4:  for (int i = 0; i < c.getAlumnosMatriculados().size(); i++) {
				c.getAlumnosMatriculados().get(i).mostrarAlumno();
			}
				break;
			case 5: System.out.println("Has salido con exito");
				break;
			default:
				System.out.println("Debe ser entre 1 y 5");
			}
		}
		
		
		Sc.close();
	}
}
