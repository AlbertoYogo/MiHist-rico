package Arrays;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		/*Se quiere hacer un programa para rellenar una apuesta sencilla del sorteo "El
		gordo de la primitiva". En este sorteo se deben rellenar cinco casillas del bloque 1
		(números del 1 al 54) y 1 casilla del bloque 2 (números del 0 al 9). Teniendo en
		cuenta que los números del bloque 1 no se pueden repetir, elaborar un programa
		que de forma aleatoria nos muestre una apuesta válida para este juego*/
		int bloque1 []=new int [5];
		int bloque2 =(int) (1+Math.random()*9);
		int aleatorio=0;
		
		for (int i = 0; i < bloque1.length; i++) {
			aleatorio=(int) (1+Math.random()*54);
			for (int j = 0; j < bloque1.length; j++) {
				if (aleatorio==bloque1[j]) {
					i--;
					aleatorio=0;
				}//if for j
			}//for j
			bloque1[i]=aleatorio;
			
		}//for int i
		
		System.out.println("Bloque 1:");
		for (int i = 0; i < bloque1.length; i++) {
			System.out.print(bloque1[i]+ "  ");
		}
		System.out.println("");
		System.out.println("Bloque 2:");
		System.out.println(bloque2);
	}
}
