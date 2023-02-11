package Ejercicios;

import java.util.Scanner;

public class Ejercicio6 {
	
   public static void main (String[] args) {
	   int numero = 0;
	   int suma = 0, contador = 0;
	   Scanner escaner = new Scanner(System.in);
	   System.out.println("Introduce un número");
		numero = escaner.nextInt();
		
		while(numero>=0);
		{
			suma+=numero;
			contador++;
			System.out.print("Introduce otro número:");
			numero= escaner.nextInt();
		}   
	   System.out.println("La media de los números positivos es: "+(suma/contador));
	   escaner.close();
   }
}
