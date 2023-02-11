package Mascotas;

import java.util.ArrayList;

public class Programa {
	private ArrayList<Mascota> mascotas;
	
	public Programa() {
		this.mascotas=new ArrayList<>();
	}

	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	
	public void mayorEdad() {
		int edad=0;
		String nombre="";
		for (Mascota mascota : this.mascotas) {
			System.out.println(mascota);
			if(mascota instanceof Perro ) {
				if(((Perro) mascota).isEstaLadrando() & mascota.getEdad()>edad) {
					edad=mascota.getEdad();
					nombre=mascota.getNombre();
				}
			}
			
			if(mascota instanceof Gato ) {
				if(((Gato) mascota).isEstaMaullando() & mascota.getEdad()>edad) {
					edad=mascota.getEdad();
					nombre=mascota.getNombre();
				}
			}
		}
			
		System.out.println("El animal mayor que está ladrando o maullando es: " +nombre);
		
	}
	
	public static void main(String[] args) {
		Programa p=new Programa();
		p.getMascotas().add(new Perro(10, "Snoopy", false));
		p.getMascotas().add(new Perro(9, "Luna", true));
		p.getMascotas().add(new Gato(11, "Finn", false));
		p.getMascotas().add(new Gato(11, "Reyna", true));
		p.mayorEdad();
	}
	
}
