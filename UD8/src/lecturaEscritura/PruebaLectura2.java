package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLectura2 {
	
	public static void main(String[] args) {	
		
		try {
			//Leemos los numeros del fichero
			File fichero=new File("numero.txt");	
			Scanner entrada=new Scanner(fichero);
			
			String cadena="";
			int total=0;
			while(entrada.hasNext()) {
				cadena=entrada.next();
				System.out.print(cadena+ " ");
				
				total+=Integer.parseInt(cadena);
			}
			
			System.out.println("");
			System.out.println("La suma total da: " +total);
			
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
