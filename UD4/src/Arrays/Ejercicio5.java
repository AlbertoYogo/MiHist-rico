package Arrays;

import java.util.Scanner;

public class Ejercicio5 {
	
	static void petici�n() {
		System.out.print("Dame un n�mero:");
	}

	public static void main(String[] args) {
		/*Realiza un programa que pida al usuario cinco n�meros y los muestre en pantalla
		ordenados de menor a mayor*/
		int n�meros[]=new int[5];
		Scanner Sc=new Scanner(System.in);
		for (int i = 0; i < n�meros.length; i++) {
			petici�n();
			n�meros[i]=Sc.nextInt();
		}
		
		Sc.close();
	}
}
