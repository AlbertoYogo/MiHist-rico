package Actividad;

import java.util.Scanner;

public class ActividadClase {
	
	static void menu() {
		System.out.println("a. Comprobar si son números amigos");
		System.out.println("b. Mostrar los números primeros entre ambos números");
		System.out.println("c. Mostrar los números palíndromos entre ambos números");
		System.out.println("d. Sumar las cifras de ambos números");
		System.out.println("e. Salir");
		System.out.println("Elija una opción:");
	}
	
	static boolean comprobacion(int A, int B) {
		boolean numeros=true;
		if (A!=B) {
			if (A>0 && B>0) {
				numeros=false;
			}//if2
		}//if1
		return numeros;
	}//comprobacion
	static int primos(int A, int B) {
		int aux=0, contadorprimos=0, contador=0;
		if (B>A) {
			aux=A;
			A=B;
			B=A;
		}//if
		while (A!=B) {
			
			for (int i=1; i<=B; i++) {
				if (B%i==0) {
					contador++;
				}//if
			}//for
			
			if (contador==2) {
				contadorprimos++;
			}//if
			contador=0;
			B++;
		}//while
		return contadorprimos;
	}//primos
	
	public static void main(String[] args) {
		
		Scanner S=new Scanner (System.in);
		int a=0, b=0, primos=0;
		String opcion="";
		boolean salir=true;
		do {
			System.out.println("Introduce dos números");
			a=S.nextInt();
			b=S.nextInt();		
		}while(comprobacion(a, b));//do-while
		while (salir) {
			menu();
		opcion=S.next();
			switch (opcion) {
				case "a":
					break;
				case "b": primos=primos(a, b);
						System.out.println("Hay "+primos+" números primos entre ambos números");
					break;
				case "c": 
					break;
				case "d": 
					break;
				case "e": salir=false;
					break;
			
				
			}//switch
		}//while
		
		S.close();
	}
}
