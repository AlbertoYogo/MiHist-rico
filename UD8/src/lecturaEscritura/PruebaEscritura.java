package lecturaEscritura;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PruebaEscritura {

	public static void main(String[] args) {
		//Va a escribir n�meros en un fichero (cada n�mero en una l�nea)
		//Hasta que el usuario introduzca el 0
		//File fichero=new File("numero.txt");
		File fichero3=new File("numerosLinea.txt");
		
		try {
			PrintWriter salida=new PrintWriter(fichero3);
			//FileWriter fichero2= new FileWriter("numeros.txt", true);
			//PrintWriter salida2=new PrintWriter(fichero2);
			
			
			int numero;
			Scanner Sc=new Scanner(System.in);
			
			do {
				System.out.println("Dame un n�mero");
				numero=Sc.nextInt();
					//Para que salga separado (saltando de l�nea)
				salida.println(numero);
				
					//Para que salga en la misma linea
				//salida.print(numero+" ");
				
					//Para que se quede guarda lo de antes
				//salida2.print(numero+ " ");
				
			}while(numero!=0);
		
			salida.flush();
			salida.close();
			
			
			//salida2.flush();
			//salida2.close();
			
			Sc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
