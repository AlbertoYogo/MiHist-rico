package aparcamiento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Aparcamiento implements Serializable {

	private ArrayList<Conductor> conductores;
	private ArrayList<Cliente> clientesaparcamiento;
	
	public Aparcamiento() {
		this.conductores=new ArrayList<>();
		this.clientesaparcamiento=new ArrayList<>();
	}

	public ArrayList<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(ArrayList<Conductor> conductores) {
		this.conductores = conductores;
	}

	public ArrayList<Cliente> getClientesaparcamiento() {
		return clientesaparcamiento;
	}

	public void setClientesaparcamiento(ArrayList<Cliente> clientesaparcamiento) {
		this.clientesaparcamiento = clientesaparcamiento;
	}
	
	
	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);
		int opcion=1;
		Aparcamiento a=new Aparcamiento();
		
		do {
			menu();
			opcion=Sc.nextInt();
			
			switch (opcion) {
			case 1: a.leerConductores("conductor.csv");
				break;
			case 2: a.altaCliente();
				break;
			case 3: a.guardarCliente();
				break;
			case 4: a.leerClientes();
				break;
			case 5: a.generarTickets();
				break;
			case 6: a.turnoEntrega();
				break;
			}
		}while(opcion!=0);
		
		Sc.close();
	}

	private static void menu() {
		System.out.println("1. Leer conductores");
		System.out.println("2. Dar de alta cliente");
		System.out.println("3. Guardar clientes");
		System.out.println("4. Leer clientes");
		System.out.println("5. Generar Tickets");
		System.out.println("6. Imprimir turno de entrega");
		System.out.println("0. Salir");
		System.out.println("Elige una opción:");
	}
	
	private void leerConductores(String filename) {
		File fichero=new File(filename);
		Scanner entrada;
		try {
			entrada = new Scanner(fichero);
			String linea=entrada.nextLine();
			String[] partes;
			while(entrada.hasNext()) {
				linea=entrada.nextLine();
				partes=linea.split(";");
				this.conductores.add(new Conductor(partes[2], partes[3], partes[4], Integer.parseInt(partes[5]), partes[6], partes[7], Integer.parseInt(partes[0]), Integer.parseInt(partes[1])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	private void altaCliente() {
		Scanner Sc=new Scanner(System.in);
		String DNI;
		String nombre;
		String apellidos;
		int edad;
		String direccion;
		String email;
		Double llegada;
		int estancia;
		
		System.out.println("DNI");
		DNI=Sc.next();
		System.out.println("Nombre");
		nombre=Sc.next();
		System.out.println("Apellidos");
		apellidos=Sc.next();
		System.out.println("Edad");
		edad=Sc.nextInt();
		System.out.println("Dirección");
		direccion=Sc.next();
		System.out.println("email");
		email=Sc.next();
		System.out.println("Hora de llegada");
		llegada=Sc.nextDouble();
		System.out.println("Días de estancia");
		estancia=Sc.nextInt();
		
		System.out.println("Coche, Moto o Furgoneta");
		String vehiculo=Sc.next();
		
		System.out.println("Matricula (Ej:1234-ABC)");
		String matricula=Sc.next();
		
		System.out.println("Color");
		String color=Sc.next();
		
		System.out.println("Marca");
		String marca=Sc.next();
		
		System.out.println("Modelo");
		String modelo=Sc.next();
		Cliente c=new Cliente(DNI, nombre, apellidos, edad, direccion, email, llegada, estancia, null);
		
		switch (vehiculo) {
		case "Coche":
			System.out.println("Puertas");
			int puertas=Sc.nextInt();
			Coche c1=new Coche(matricula, color, marca, modelo, puertas);
			c.setV(c1);
			break;
		case "Moto":
			System.out.println("Tipo");
			String tipo=Sc.next();
			System.out.println("Cilindrada");
			double cilindrada=Sc.nextDouble();
			System.out.println("Carnet");
			String carnet=Sc.next();
			Moto m1=new Moto(matricula, color, marca, modelo, tipo, cilindrada, carnet);
			c.setV(m1);
			break;
		case "Furgoneta":
			System.out.println("Capacidad");
			int capacidad=Sc.nextInt();
			Furgoneta f1=new Furgoneta(matricula, color, marca, modelo, capacidad);
			c.setV(f1);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + vehiculo);
		}
		
		this.clientesaparcamiento.add(c);
	}
	
	private void guardarCliente() {
		try {
			FileOutputStream fichero=new FileOutputStream("clientes.par");
			ObjectOutputStream salida=new ObjectOutputStream(fichero);
			
			for (Cliente cliente : this.clientesaparcamiento) {
				salida.writeObject(cliente);
			}
			
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void leerClientes() {
		try {
			FileInputStream fichero=new FileInputStream("clientes.par");
			ObjectInputStream entrada=new ObjectInputStream(fichero);	
			Cliente c=null;
			while(entrada!=null) {
				try {
					c=(Cliente)entrada.readObject();
					this.clientesaparcamiento.add(c);
				} catch (IOException | ClassNotFoundException e) {
					entrada=null;
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void generarTickets() {
		for (Cliente cliente : this.clientesaparcamiento) {
			String filename="Ticket"+cliente.getNombre().trim()+cliente.getApellidos().trim();
			File fichero=new File(filename+".txt");
			try {
				PrintWriter salida=new PrintWriter(fichero);
				int precio=0;
				int total=0;
				if (cliente.getV() instanceof Moto) {
					precio=5;
				}else {
					if(cliente.getV() instanceof Coche) {
						precio=10;
					}else {
						precio=15;
					}
				}
				
				total=precio*cliente.getEstancia();
				salida.println("Precio base del vehículo: " +precio+"€");
				salida.println("Precio total: " +total+"€");
				salida.println("Dias de estancia: " +cliente.getEstancia());
				
				salida.flush();
				salida.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	private void turnoEntrega() {
		for (Conductor conductor : this.conductores) {
			System.out.println("Conductor: " +conductor.getNombre());
			for (Cliente cliente :this.clientesaparcamiento) {
				if(conductor.getTurno()==1 && cliente.getLlegada()>=8 & cliente.getLlegada()<16) {
					System.out.println("Turno 1:");
					System.out.println(cliente);
				}else {
					if(conductor.getTurno()==2 && cliente.getLlegada()>=16 & cliente.getLlegada()<25) {
						System.out.println("Turno 2:");
						System.out.println(cliente);
					}else {
						if(conductor.getTurno()==3 && cliente.getLlegada()>=1 & cliente.getLlegada()<8) {
							System.out.println("Turno 3:");
							System.out.println(cliente);
						}
					}
				}
			}
			
		}
	}
	
}
