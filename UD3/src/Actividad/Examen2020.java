package Ampliaci�nYRefuerzo;

import java.util.Scanner;

public class Examen2020 {
	public static void main(String[] args) {
		/*Crea un programa Java en el que el usuario introduce n�meros hasta que se pulsa el 
		n�mero 0. Para cada uno de los n�meros introducidos calcula:
		1) El n�mero de cifras
		2) La suma de sus cifras
		3) �Cu�ntas cifras son pares y cu�ntas impares?
		Cuando el programa termina indica qu� n�mero de todos los introducidos ha sido el 
		mayor y cu�l el menor (no es el cero)*/
		
		Scanner S=new Scanner(System.in);
		int n=1, cifras=0, suma=0, contadorpar=0, contadorimpar=0, mayor=0, menor=1000000000, parimpar=0;
		
		while (n!=0) {
			
			System.out.println("Introduzca un n�mero");
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
			System.out.println("Este n�mero tiene " +contadorpar+ " cifras pares");
			System.out.println("Este n�mero tiene " +contadorimpar+ " cifras impares");
			
			cifras=0;
			suma=0;
			parimpar=0;
			contadorpar=0;
			contadorimpar=0;
			
			n=1;
			 
			}//if1
			 
		}//while
		
		System.out.println("El n�mero mayor es " +mayor);
		System.out.println("El n�mero menor es " +menor);
		
		S.close();
	}
	
}
