package Ejercicios;

import java.util.Scanner;

public class Ejercicio6 {
	
   public static void main (String[] args) {
	   int numero = 0;
	   int suma = 0, contador = 0;
	   Scanner escaner = new Scanner(System.in);
	   System.out.println("Introduce un n�mero");
		numero = escaner.nextInt();
		
		while(numero>=0);
		{
			suma+=numero;
			contador++;
			System.out.print("Introduce otro n�mero:");
			numero= escaner.nextInt();
		}   
	   System.out.println("La media de los n�meros positivos es: "+(suma/contador));
	   escaner.close();
   }
}
