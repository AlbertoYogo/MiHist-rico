package Matrices;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*Realizar un programa que pida al usuario las filas (mínimo 2 y máximo 10) y las
		columnas (mínimo 2 y máximo 10) . Suponemos que el usuario tecleará
		correctamente los datos. Después se rellenará esta matriz con números aleatorios
		del 1 al 50 y se mostrará en pantalla.*/
		Scanner Sc=new Scanner(System.in);
		int f=0;
		int col=0;
		System.out.println("Dame el número de filas (mínimo 2 y máximo 10)");
		f=Sc.nextInt();
		System.out.println("Dame el número de filas (mínimo 2 y máximo 10)");
		col=Sc.nextInt();
		int Array[][]=new int[f][col];
		generador(Array);
		mostrarTabla(Array);
		Sc.close();
		
	}//Principal

	private static void mostrarTabla(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print("    "+array[i][j]);
			}
			System.out.println("");
		}
	}//Método para mostrar tabla

	private static void generador(int[][] array) {
		int aleatorio=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				aleatorio=(int) (1+Math.random()*50);
				array[i][j]=aleatorio;
			}
		}//Método generador
	}
}
