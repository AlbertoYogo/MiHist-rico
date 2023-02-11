package AmpliaciónYRefuerzo;

import java.util.Scanner;

public class EjercicioPalíndromoV2 {
	public static void main(String[] args) {
		/*Un entero se dice que es un palíndromo si es igual al número que se obtiene al invertir el orden de
		sus cifras.
		Por ejemplo, 79197 y 324423 son palíndromos. En esta tarea se le dará un entero N, 1 <= N <=
		1.000.000.
		Usted debe encontrar el menor entero M tal que M <= N que es primo y M es un palíndromo N.
		Por ejemplo, si N es 31, entonces la respuesta es 101.
		Formato de entrada:
		Un solo entero N, (1 <= N <= 1.000.000), en una sola línea.
		Formato de salida:
		Su salida debe consistir en un solo número entero, el más pequeño palíndromo primo mayor que o
		igual a N.*/
		
		Scanner Sc=new Scanner(System.in);
		System.out.println("Introduzca un número positivo");
		int n=Sc.nextInt(), palíndromo=0, copia=1, contadorprimo=0, cálculos=0;
		
		while (contadorprimo!=2) {
			copia=n;
			contadorprimo=0;
			
			while (n>0){
				cálculos=n%10;
				palíndromo=palíndromo*10+cálculos;
				n=n/10;
			}//whileINT
				
				if (palíndromo==copia){
					for (int i=1; i<=copia; i++) {
						if (copia%i==0) {
							contadorprimo++;
						}//IfDentroFor
					}//for
					
				}//if finalpalíndromo
				
				if (contadorprimo==2) {
					System.out.println(copia+ " es el siguiente número primo y palíndromo");
				}//ifprimo
				
				
				n=copia+1;
				copia++;
				palíndromo=0;
				
		}//while1
		
		
		Sc.close();
	}

}
