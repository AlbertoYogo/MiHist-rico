package PruebaAL;

import java.util.ArrayList;

public class Concesionario {
	private ArrayList<Coche> miscoches;
	
	public Concesionario() {
		this.miscoches= new ArrayList<Coche>();
	}

	public ArrayList<Coche> getMiscoches() {
		return miscoches;
	}

	public void setMiscoches(ArrayList<Coche> miscoches) {
		this.miscoches = miscoches;
	}
	
	public static void main(String[] args) {
		Concesionario c=new Concesionario();
		Coche c1=new Coche("1111FFF", "Alfa", 3, "Romeo");
		Coche c2=new Coche("2222FFF", "Ibiza", 3, "Seat");
		Coche c3=new Coche("3333FFF", "Coche", 5, "Opel");
		Coche c4=new Coche("4444FFF", "Cooper", 3, "Mini");
		
		//Añadimos coche al AL.
		c.getMiscoches().add(c1);
		c.getMiscoches().add(c2);
		c.getMiscoches().add(c3);
		c.getMiscoches().add(c4);
		
		Coche c5=new Coche("5555FFF", "Testarosa", 5, "Ferrari");
		c.getMiscoches().add(2, c5);
		
		//Borrar un objeto del AL.
		c.getMiscoches().remove(c4);
		
		for(Coche x: c.getMiscoches()) {
			System.out.println(x);
		}
		
	}
	
}
