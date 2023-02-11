package lecturaEscrituraObjetos;

import java.util.Scanner;

public class Programa {
	public void menu() {
		System.out.println("1)Imprimir agenda");
		System.out.println("2) Añadir contacto");
		System.out.println("3) Eliminar contacto");
		System.out.println("4) Salir");
		System.out.println("Elige una opcion: ");
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean salir=false;
		int opcion;
		Programa p=new Programa();
		Agenda agenda=new Agenda();
		agenda.cargarAgenda("contactos.bin");
		String nombre="",direccion="", email="",telefono="";
		do {
			p.menu();
			opcion=sc.nextInt();
			sc.nextLine();
			switch(opcion) {
			
			case 1:
				agenda.imprimirAgenda();
				break;
			case 2: 
				System.out.println("Nombre: ");
				nombre=sc.nextLine();
				System.out.println("Telefono: ");
				telefono=sc.next();
				System.out.println("Direccion: ");
				direccion=sc.next();
				System.out.println("Correo: ");
				email=sc.next();
				agenda.addContacto(new Contacto(nombre, telefono, direccion, email));
				break;
			case 3:
				agenda.imprimirAgenda();
				System.out.println("¿Qué contacto quieres borrar?");
				nombre=sc.nextLine();
				agenda.eliminarContacto(nombre);
				agenda.imprimirAgenda();
				break;
			case 4:
				agenda.guardarAgenda("contacots.bin");
				salir=true;
				break;
			}
			
		}while(!salir);
		
		
	}
	

}