package Arrays;

import java.util.Scanner;

public class Ejercicio3 {
	
	static float media(float temperaturas[]) {
		float suma=0;
		for (int i = 0; i < temperaturas.length; i++) {
			suma= suma+temperaturas[i];
		}
		
		return suma/temperaturas.length;
	}//Método para hacer la media,
	
	static void encima (float temperaturas[], float media, String diasSemana[]) {
		for (int i = 0; i < temperaturas.length; i++) {
			if (temperaturas[i]>media) {
				System.out.println("La temperatura del " +diasSemana[i]+ "(" +temperaturas[i]+ ") es mayor que la media");
			}	
		}
	}//Método para calcular las temperaturas por encima de la media.
	
	static void debajo (float temperaturas[], float media, String diasSemana[]) {
		for (int i = 0; i < temperaturas.length; i++) {
			if (temperaturas[i]<media) {
				System.out.println("La temperatura del " +diasSemana[i]+ "(" +temperaturas[i]+ ") es menor que la media");
			}	
		}
	}//Mñetodo para calcular las temperaturas por debajo de la media.
	
	public static void main(String[] args) {
		/*Realizar un programa que pide al usuario la temperatura de los 7 días de la
		semana y después muestra la temperatura media de la semana y los días en los que
		la temperatura ha estado por encima de la media y los días que ha estado por
		debajo de ella*/
		
		//Declaraciones.
		Scanner Sc=new Scanner(System.in);
		float temperaturas[]=new float[7];
		float media=0;
		String diasSemana[]= {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
		//For para pedir las temperaturas de la semana.
		for (int i = 0; i < temperaturas.length; i++) {
			System.out.println("Dame la temperatura de la posicción " +diasSemana[i]);
			temperaturas[i]=Sc.nextFloat();
		}
		
		//Llamadas a métodos para hacer las 3 operaciones.
		media=media(temperaturas);
		System.out.println("La media de la temperatura es: " +media);
		encima(temperaturas, media, diasSemana);
		debajo(temperaturas, media, diasSemana);
		Sc.close();
	}
}
