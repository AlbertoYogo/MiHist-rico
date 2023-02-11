package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLecturaNotas2 {
	
	public static void main(String[] args) {
		try {
			//Leemos los numeros del fichero
			File fichero=new File("notas.txt");	
			Scanner entrada=new Scanner(fichero);
			String linea[];
			
			String cadena="";
			double total=0;
			while(entrada.hasNext()) {
				//Leo la línea del fichero
				cadena=entrada.nextLine();

					//Separa por espacio en blanco
				linea=cadena.split(" ");
				System.out.println("Nombre: " +linea[0]+" Apellido: " +linea[1]);
					//Bucle para hacer la media
				//Sumo los valores de las notas (que van de  la posicion 1 a la 4
				for (int i = 2; i < linea.length; i++) {
					total+=Double.parseDouble(linea[i]);
				}
				
				System.out.println("     Nota media: " +total/4);
				
				//Reinicimos la variable total para que no se acumule
				total=0;
			}

			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
