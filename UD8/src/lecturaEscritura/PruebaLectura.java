package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLectura {
	
	public static void main(String[] args) {	
		
		try {
			//Leemos los numeros del fichero
			File fichero=new File("numerosLinea.txt");	
			Scanner entrada=new Scanner(fichero);
			
			String cadena="";
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				System.out.println(cadena);
			}
			
			
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
