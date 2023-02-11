package Arrays;

import java.util.Scanner;

public class Ejercicio5 {
	
	static void petición() {
		System.out.print("Dame un número:");
	}

	public static void main(String[] args) {
		/*Realiza un programa que pida al usuario cinco números y los muestre en pantalla
		ordenados de menor a mayor*/
		int números[]=new int[5];
		Scanner Sc=new Scanner(System.in);
		for (int i = 0; i < números.length; i++) {
			petición();
			números[i]=Sc.nextInt();
		}
		
		Sc.close();
	}
}
