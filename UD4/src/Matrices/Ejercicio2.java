package Matrices;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		/*Realizar un programa que pida al usuario las filas (m�nimo 2 y m�ximo 10) y las
		columnas (m�nimo 2 y m�ximo 10) . Suponemos que el usuario teclear�
		correctamente los datos. Despu�s se rellenar� esta matriz con n�meros aleatorios
		del 1 al 50 y se mostrar� en pantalla.*/
		Scanner Sc=new Scanner(System.in);
		int f=0;
		int col=0;
		System.out.println("Dame el n�mero de filas (m�nimo 2 y m�ximo 10)");
		f=Sc.nextInt();
		System.out.println("Dame el n�mero de filas (m�nimo 2 y m�ximo 10)");
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
	}//M�todo para mostrar tabla

	private static void generador(int[][] array) {
		int aleatorio=0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				aleatorio=(int) (1+Math.random()*50);
				array[i][j]=aleatorio;
			}
		}//M�todo generador
	}
}
