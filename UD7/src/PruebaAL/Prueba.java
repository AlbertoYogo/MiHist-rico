package PruebaAL;

import java.util.ArrayList;
import java.util.LinkedList;

public class Prueba {
	public static void main(String[] args) {
		
		int array[]= {1,5,6,3,2};
		
		//A�adir un elemento al array -> NO puedo as�.
		
		
		ArrayList <Integer> numeros=new ArrayList<>();
		//*IMPORTANTE: hay que importar.
		
		//A�adir un elemento al AL.
		System.out.println("A�adimos n�meros");
		numeros.add(1);
		numeros.add(3);
		numeros.add(5);
		numeros.add(7);
		numeros.add(9);
		System.out.println(numeros);
		
		System.out.println("A�adimos el 4 a mitad del ArrayList");
		numeros.add(3, 4);
		System.out.println(numeros);
		
		//Borrar elemento
		System.out.println("Boramos el elemento de la segunda posici�n");
		numeros.remove(1);
		System.out.println(numeros);
		
		//Recorrer. *Recordar el .size
		System.out.println("Recorremos uno a uno");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.print(numeros.get(i)+ "   ");
		}
		
		//Otra forma de recorrer el AL.
		System.out.println("");
		System.out.println("Con otra forma de recorrer el AL");
		for(Integer n: numeros) {
			//El par�ntesis: es como decir "para cada objeto 'n' (En este caso)
			//del Array: n�meros"
			System.out.println(numeros.get(n));
		}
		
		
		//Listas enlazadas
		LinkedList <Integer> enlazada=new LinkedList<>();
		//Estos dos m�todos son las diferencias con el ArrayList. Lo dem�s es igual.
		enlazada.addFirst(9);
		enlazada.removeLast();
		
		
	}
}
