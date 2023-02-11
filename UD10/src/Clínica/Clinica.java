package Clínica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Clinica implements EntradasUsuario {
	ArrayList<Profesionales> medicos;
	LinkedList<Pacientes> pacientes;

	@Override
	public boolean isNum(String n) {
		return n.matches("[0-9]*");
	}
	
	public Clinica() {
		this.medicos=new ArrayList<>();
		this.pacientes=new LinkedList<>();
	}

	public ArrayList<Profesionales> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<Profesionales> medicos) {
		this.medicos = medicos;
	}

	public LinkedList<Pacientes> getPacientes() {
		return pacientes;
	}

	public void setPacientes(LinkedList<Pacientes> pacientes) {
		this.pacientes = pacientes;
	}
	
	public static void main(String[] args) {
		Clinica c=new Clinica();
		c.cargaInicial();
		String opcion="0";
		Scanner Sc=new Scanner(System.in);
		
		while(!c.isNum(opcion) || Integer.parseInt(opcion)!=4) {
			menu();
			opcion=Sc.next();
			
			switch (opcion) {
			case "1":
				c.listadoPacientes();
				break;
			case "2":
				c.cargarHistorias();
				break;
			case "3":
				System.out.println("Dame el DNI");
				String DNI=Sc.next();
				for (Pacientes paciente : c.getPacientes()) {
					if(DNI.equals(paciente.getDNI())) {
						c.atenderCliente(paciente);
						paciente.GuardarHistoria();
					}
				}
				
				break;

			}
		}
		
		Sc.close();
		
		
	}
	
	private void atenderCliente(Pacientes p) {
		String historia;
		if (p.getHistoria()!=null) {
			historia=p.getHistoria()+"\n";
		}
		else {
			historia="";
		}
		String linea="";
		Scanner escaner=new Scanner(System.in);
		
		System.out.println("Motivo de la consulta");
		do {
			linea=escaner.nextLine();
			historia=historia+ linea+ "\n";
			if(!linea.equals("Fin")) {
				p.setHistoria(historia);
			}
		}while(!linea.equals("Fin"));
		
		escaner.close();
	}

	public void cargarHistorias() {
		for (int i = 0; i < this.pacientes.size(); i++) {
			String filename="Historia"+this.pacientes.get(i).getDNI()+".txt";
			File fichero=new File(filename);
			if(fichero.exists()) {
				try {
						String historia="";
						Scanner entrada=new Scanner(fichero);
						//System.out.println("Existe " +filename);
						while(entrada.hasNext()) {
							historia=historia+entrada.nextLine()+"\n";
						}
						this.pacientes.get(i).setHistoria(historia);
						entrada.close();
					}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	public void listadoPacientes() {
		for (Profesionales medico : this.medicos) {
			System.out.println("*****************  " +medico.getEspecialidad()+ "  *****************");
			System.out.println("La lista de pacientes de Dr/Dra " +medico.getNombre()+" "+medico.getApellidos()+" es: ");
			for (Pacientes paciente : this.pacientes) {
				if(paciente.getCita().equals(medico.getEspecialidad())) {
					System.out.println("        "+ paciente.getNombre()+" "+paciente.getApellidos());
					System.out.println("");
				}
			}
		}
		
	}

	public static void menu() {
		System.out.println("1. Listado de pacientes");
		System.out.println("2. Cargar historias clinicias");
		System.out.println("3. Atender paciente");
		System.out.println("4. Salir");
		System.out.println("Elige una opción:");
		
	}

	public void cargaInicial() {
		File fichero=new File("personas.csv");
		try {
			Scanner entrada=new Scanner(fichero);
			String linea=entrada.nextLine();
			String[] partido;
			
			while(entrada.hasNext()) {
				linea=entrada.nextLine();
				partido=linea.split(";");
				if(partido[0].equals("medico")) {
					this.medicos.add(new Profesionales(partido[1], partido[2], partido[3], Integer.parseInt(partido[4]), partido[5], Integer.parseInt(partido[6])));
				}
				else {
					this.pacientes.addLast(new Pacientes(partido[1], partido[2], partido[3], Integer.parseInt(partido[4]), Integer.parseInt(partido[7]), Integer.parseInt(partido[8]), partido[10], null));
				}
			}
			
			entrada.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
