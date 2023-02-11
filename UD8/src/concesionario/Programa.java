package concesionario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import alumnos.Correo;

public class Programa {

	public static void main(String[] args) {
		
		ArrayList<Coche> miscoches=new ArrayList<>();
		File fichero=new File("BDCoches.csv");
		Scanner entrada;
		
		try {
			entrada=new Scanner(fichero);
			String cadena="";
			String linea[];
			cadena=entrada.nextLine();
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(";");
				miscoches.add(new Coche(linea[0], linea[2], linea[1], Double.parseDouble(linea[3])));
			}
			
			for(Coche c: miscoches) {
				System.out.println(c);
			}
			
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
