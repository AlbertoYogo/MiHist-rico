package ProyectoCine;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa {
	ArrayList <Pelicula> pelis;

	
	//Constructor
	public Programa() {
		this.pelis= new ArrayList<Pelicula>();
	}

	
	//Getter y setter
	public ArrayList<Pelicula> getPelis() {
		return pelis;
	}


	public void setPelis(ArrayList<Pelicula> pelis) {
		this.pelis = pelis;
	}
	
	//A�adir pel�cula
	public void a�adirPelicula(Pelicula p) {
		this.getPelis().add(p);
	}
	
	//Borrar pel�cula
	public void borrarPelicula(Pelicula p) {
		this.getPelis().remove(p);
	}
	
	//Mostrar pel�cular
	public void mostrarPeliculas() {
		for (int i = 0; i < this.getPelis().size(); i++) {
			this.getPelis().get(i).mostrarPelicula();
		}
	}
	
	//Buscar g�nero
	public void buscarGenero(String genero) {
		for (int i = 0; i < this.getPelis().size(); i++) {
			if (this.getPelis().get(i).getGenero().equals(genero)) {
				this.getPelis().get(i).mostrarPelicula();
			}
		}
	}
	
	public static void main(String[] args) {
		int a�o;
		String genero;
		String director;
		String nombre;
		int opcion=0;
		Scanner Sc=new Scanner(System.in);
		Programa pro=new Programa();
		
		while (opcion!=5) {
			System.out.println("1. A�adir peli");
			System.out.println("2. Borrar peli");
			System.out.println("3. Mostrar peli");
			System.out.println("4. Buscar genero");
			System.out.println("5. Salir");
			System.out.println("Elige una opci�n");
			opcion= Sc.nextInt();
			
			switch (opcion) {
			case 1: System.out.println("a�o");
					a�o= Sc.nextInt();
					System.out.println("genero");
					genero= Sc.next();
					System.out.println("director");
					director=Sc.next();
					System.out.println("nombre");
					nombre=Sc.next();
					Pelicula P=new Pelicula(a�o, director, genero, nombre);
					pro.a�adirPelicula(P);
				break;
			case 2:
				System.out.println("a�o");
				a�o= Sc.nextInt();
				System.out.println("genero");
				genero= Sc.next();
				System.out.println("director");
				director=Sc.next();
				System.out.println("nombre");
				nombre=Sc.next();
				Pelicula P2=new Pelicula(a�o, director, genero, nombre);
				pro.borrarPelicula(P2);
				break;
			case 3: pro.mostrarPeliculas();
				break;
			case 4: System.out.println("genero");
					genero= Sc.next();
					pro.buscarGenero(genero);
				break;
			case 5:
				break;
			default: System.out.println("Entre 1 y 5");
			}
		}
	}
}
