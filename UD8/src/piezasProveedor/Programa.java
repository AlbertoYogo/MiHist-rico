package piezasProveedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Programa {
	private ArrayList<Pieza> piezas;
	private ArrayList<Proveedor> proveedores;
	
	public Programa() {
		this.piezas=new ArrayList<>();
		this.proveedores=new ArrayList<>();
	}

	public ArrayList<Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(ArrayList<Pieza> piezas) {
		this.piezas = piezas;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	@Override
	public String toString() {
		return "Programa [piezas=" + piezas + ", proveedores=" + proveedores + "]";
	}
	
	public void generarFichero(String filename) {
		File fichero=new File(filename);
		try {
			PrintWriter salida=new PrintWriter(fichero);
			for (Proveedor p: this.getProveedores()) {
				salida.println("El proveedor " +p.getNombreProveedor()+ " suministra:");
				for(Pieza pieza: this.getPiezas()) {
					if (p.getCodProveedor()==pieza.getProveedor()) {
						salida.println("           " +pieza.getNombrePieza());
					}
				}
			}
			
			salida.flush();
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Programa p=new Programa();
		Utilidades u=new Utilidades();
		p.setPiezas(u.leerPiezas("piezas.csv"));
		p.setProveedores(u.leerProveedor("proveedor.csv"));
		
		p.generarFichero("proveedorPieza.txt");
	}
	
}
