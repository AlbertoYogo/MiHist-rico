package piezasProveedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilidades {
	
	public ArrayList<Pieza> leerPiezas(String filename) {
		//Declaraciones
		ArrayList<Pieza> piezas=new ArrayList<>();
		File fichero=new File(filename);
		String pieza;
		String partido[];
		
		try {
			//Scanner
			Scanner entrada=new Scanner(fichero);
			pieza=entrada.nextLine();
			while(entrada.hasNext()) {
				pieza=entrada.nextLine();
				partido=pieza.split(";");
				piezas.add(new Pieza(Integer.parseInt(partido[0]), partido[1], Integer.parseInt(partido[2]), Integer.parseInt(partido[3])));
			}
			
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return piezas;
	}
	
	 public ArrayList<Proveedor> leerProveedor(String filename) {
		//Declaraciones
			ArrayList<Proveedor> proveedores=new ArrayList<>();
			File fichero=new File(filename);
			String proveedor;
			String partido[];
			
			try {
				//Scanner
				Scanner entrada=new Scanner(fichero);
				proveedor=entrada.nextLine();
				while(entrada.hasNext()) {
					proveedor=entrada.nextLine();
					partido=proveedor.split(";");
					proveedores.add(new Proveedor(Integer.parseInt(partido[0]), partido[1], partido[2]));
				}
				
				entrada.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return proveedores;
	 }
	
}
