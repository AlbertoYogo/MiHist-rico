package Ampliaci�nYRefuerzo;

import java.util.Scanner;

public class EjercicioPal�ndromoV2 {
	public static void main(String[] args) {
		/*Un entero se dice que es un pal�ndromo si es igual al n�mero que se obtiene al invertir el orden de
		sus cifras.
		Por ejemplo, 79197 y 324423 son pal�ndromos. En esta tarea se le dar� un entero N, 1 <= N <=
		1.000.000.
		Usted debe encontrar el menor entero M tal que M <= N que es primo y M es un pal�ndromo N.
		Por ejemplo, si N es 31, entonces la respuesta es 101.
		Formato de entrada:
		Un solo entero N, (1 <= N <= 1.000.000), en una sola l�nea.
		Formato de salida:
		Su salida debe consistir en un solo n�mero entero, el m�s peque�o pal�ndromo primo mayor que o
		igual a N.*/
		
		Scanner Sc=new Scanner(System.in);
		System.out.println("Introduzca un n�mero positivo");
		int n=Sc.nextInt(), pal�ndromo=0, copia=1, contadorprimo=0, c�lculos=0;
		
		while (contadorprimo!=2) {
			copia=n;
			contadorprimo=0;
			
			while (n>0){
				c�lculos=n%10;
				pal�ndromo=pal�ndromo*10+c�lculos;
				n=n/10;
			}//whileINT
				
				if (pal�ndromo==copia){
					for (int i=1; i<=copia; i++) {
						if (copia%i==0) {
							contadorprimo++;
						}//IfDentroFor
					}//for
					
				}//if finalpal�ndromo
				
				if (contadorprimo==2) {
					System.out.println(copia+ " es el siguiente n�mero primo y pal�ndromo");
				}//ifprimo
				
				
				n=copia+1;
				copia++;
				pal�ndromo=0;
				
		}//while1
		
		
		Sc.close();
	}

}
