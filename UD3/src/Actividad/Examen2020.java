package AmpliaciónYRefuerzo;

import java.util.Scanner;

public class Examen2020 {
	public static void main(String[] args) {
		/*Crea un programa Java en el que el usuario introduce números hasta que se pulsa el 
		número 0. Para cada uno de los números introducidos calcula:
		1) El número de cifras
		2) La suma de sus cifras
		3) ¿Cuántas cifras son pares y cuántas impares?
		Cuando el programa termina indica qué número de todos los introducidos ha sido el 
		mayor y cuál el menor (no es el cero)*/
		
		Scanner S=new Scanner(System.in);
		int n=1, cifras=0, suma=0, contadorpar=0, contadorimpar=0, mayor=0, menor=1000000000, parimpar=0;
		
		while (n!=0) {
			
			System.out.println("Introduzca un número");
			n=S.nextInt();
			
			if (n!=0) {
				 
				if (n>mayor) {
					mayor=n;
				}//if2
				
				if (n<menor) {
						menor=n;
				}//if3
				
				
			while (n!=0) {
				cifras++;
				suma += n%10;
				parimpar=n%10;
					if (parimpar%2==0) {
						contadorpar++;
					}//if5
					else {
						contadorimpar++;
					}//else
				n= n/10;
			}//while2
			
			if (suma<0) {
				suma=suma*-1;
			}
			
			System.out.println("Tiene " +cifras+ " cifras");
			System.out.println("La suma de sus cifras da: " +suma);
			System.out.println("Este número tiene " +contadorpar+ " cifras pares");
			System.out.println("Este número tiene " +contadorimpar+ " cifras impares");
			
			cifras=0;
			suma=0;
			parimpar=0;
			contadorpar=0;
			contadorimpar=0;
			
			n=1;
			 
			}//if1
			 
		}//while
		
		System.out.println("El número mayor es " +mayor);
		System.out.println("El número menor es " +menor);
		
		S.close();
	}
	
}
