package lecturaEscritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PruebaLecturaNotas {
	
	public static void main(String[] args) {
		
		try {
			//Leemos los numeros del fichero
			File fichero=new File("notas.csv");	
			Scanner entrada=new Scanner(fichero);
			String linea[];
			
			String cadena="";
			double total=0;
			while(entrada.hasNext()) {
				//Leo la línea del fichero
				cadena=entrada.nextLine();
				System.out.println(cadena);
				
				//Por cada línea del String cadena voy a llenar el array con
				//cada parte de la línea de cadena separada por ';'
					//Separa por punto y coma
				linea=cadena.split(";");
				
					//Bucle para hacer la media
				//Sumo los valores de las notas (que van de  la posicion 1 a la 4
				for (int i = 1; i < linea.length; i++) {
					total+=Double.parseDouble(linea[i]);
				}
				
				System.out.println("El alumno " +linea[0]+ " tiene una nota media de " +total/4);
				
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
