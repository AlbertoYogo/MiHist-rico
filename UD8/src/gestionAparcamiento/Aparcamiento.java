package gestionAparcamiento;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import lecturaEscrituraObjetos.Contacto;

public class Aparcamiento {
    private ArrayList<Conductor> conductores;
    private ArrayList<Cliente> clientesAparcamiento;
   
    public Aparcamiento(){
        conductores = new ArrayList<>();
        clientesAparcamiento = new ArrayList<>();
    }

    public void leerConductores() throws IOException {
        FileReader fr = new FileReader(".\\conductor.csv");//El fichero tiene que estar en la carpeta del proytecto pero fuera del src
        BufferedReader entrada = new BufferedReader(fr);

        String[] linea;
        String cadena = entrada.readLine();
        cadena = entrada.readLine();//!saltar la primera linea

        try {
            do {
                if (cadena.equals(null)) {
                    break;
                }
                linea = cadena.split(";");
                cadena = entrada.readLine();

                Conductor conductor = new Conductor(Integer.parseInt(linea[0]),Integer.parseInt(linea[1]),linea[2],linea[3],linea[4],Integer.parseInt(linea[5]),linea[6],linea[7]);
                conductores.add(conductor);
            } while (cadena != null);
        } catch (NullPointerException n) {
            System.out.println("Fin de fichero");
        }
        System.out.println("Fichero leido");
        fr.close();
    }

    public void darAltaCliente(){
        Scanner s = new Scanner(System.in);
        Cliente c = new Cliente();
        do {
            System.out.println("Dime el DNI del cliente");
            c.setDNI(s.next());
        }while (!c.valida(c.getDNI()));
        System.out.println("Dame el nombre del cliente");
        c.setNombre(s.next());
        System.out.println("Dame el apellido del cliente. Sin espacios");
        c.setApellidos(s.next());
        System.out.println("Dime la edad del cliente");
        c.setEdad(s.nextInt());
        System.out.println("Dime la dirección del cliente");//! se la salta por el next
        s.nextLine();
        String direccion = s.nextLine();
        c.setDireccion(direccion);
        System.out.println("Dame el email del cliente");
        c.setEmail(s.next());
        System.out.println("¿Hora de llegada?");
        c.setHoraLlegada(s.nextInt());
        System.out.println("¿Días de de estancia?");
        c.setDiasEstancia(s.nextInt());
        System.out.println("Ahora los datos del Vehículo");
        System.out.println("¿Qué tipo de vehículo es?");
        String tipo = s.next();
        if(tipo.equalsIgnoreCase("Coche")){
            Coche c1 = new Coche();
            System.out.println("Dime el modelo");
            c1.setModelo(s.next());
            System.out.println("Dime el color");
            c1.setColor(s.next());
            System.out.println("Dime la marca");
            c1.setMarca(s.next());
            do{
                System.out.println("Dime la matrícula");
                c1.setMatricula(s.next());
            }while (!c1.valida(c1.getMatricula()));
            System.out.println("Número de puertas");
            c1.setNumeroPuertas(s.nextInt());

            c.setV(c1);
        }else if(tipo.equalsIgnoreCase("Moto")){
            Moto m1 = new Moto();
            System.out.println("Dime el modelo");
            m1.setModelo(s.next());
            System.out.println("Dime el color");
            m1.setColor(s.next());
            System.out.println("Dime la marca");
            m1.setMarca(s.next());
            do{
                System.out.println("Dime la matrícula");
                m1.setMatricula(s.next());
            }while (!m1.valida(m1.getMatricula()));
            System.out.println("Cilindrada");
            m1.setCilindrada(s.nextInt());
            System.out.println("Tipo de moto");
            m1.setTipo(s.next());
            System.out.println("Carnet");
            m1.setCarnet(s.next());

            c.setV(m1);
        }else {
            Furgoneta f1 = new Furgoneta();
            System.out.println("Dime el modelo");
            f1.setModelo(s.next());
            System.out.println("Dime el color");
            f1.setColor(s.next());
            System.out.println("Dime la marca");
            f1.setMarca(s.next());
            do{
                System.out.println("Dime la matrícula");
                f1.setMatricula(s.next());
            }while (!f1.valida(f1.getMatricula()));
            System.out.println("Capacidad");
            f1.setCapacidad(s.nextInt());

            c.setV(f1);
        }

        clientesAparcamiento.add(c);
    }

    private void guardarClientes() throws IOException, ClassNotFoundException {
    	try {
			FileOutputStream fichero=new FileOutputStream("clientes.par");
			ObjectOutputStream salida=new ObjectOutputStream(fichero);
			
			for (Cliente c: this.clientesAparcamiento) {
				salida.writeObject(c);
			}
			salida.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }

    private void leerClientes() throws IOException {
        //*borrar los registros que ya había
        clientesAparcamiento = new ArrayList<>();

        try {
			FileInputStream fichero=new FileInputStream("clientes.par");
			ObjectInputStream entrada=new ObjectInputStream(fichero);
			Cliente c=null;
			while(entrada!=null) {
				try {
					c=(Cliente)entrada.readObject();
					this.clientesAparcamiento.add(c);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					entrada=null;
				}
				
			}
			
			
			  
			  fichero.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //* Imprimirlos una vez asignados al array
        for (Cliente cliente:
             clientesAparcamiento) {
            System.out.println(cliente);
        }

     
       
    }

    private void generarTickets() throws IOException {
        double importe = 0;
        for (Cliente client:
             clientesAparcamiento) {
            FileWriter fw = new FileWriter(".\\Ticket"+client.getNombre()+client.getApellidos()+".txt");
            PrintWriter salida = new PrintWriter(fw);
            if(client.getV() instanceof Coche){
                importe = client.getDiasEstancia()*10;
                salida.println("10,00€ por día");
                salida.println("Importe total a pagar: "+importe);
                salida.println("Número de días: "+client.getDiasEstancia());
            }else if (client.getV() instanceof Moto){
                importe = client.getDiasEstancia()*5;
                salida.println("5,00€ por día");
                salida.println("Importe total a pagar: "+importe);
                salida.println("Número de días: "+client.getDiasEstancia());
            }else {
                importe = client.getDiasEstancia()*15;
                salida.println("15€ por día");
                salida.println("Importe total a pagar: "+importe);
                salida.println("Número de días: "+client.getDiasEstancia());
            }
            salida.close();
        }
    }

    public void imprimirTurnos(){
        for (Conductor conductor:
             conductores) {
            for (Cliente cliente:
                 clientesAparcamiento) {
                if (conductor.getTurno() == 1 && cliente.getHoraLlegada()>=8 && cliente.getHoraLlegada()<=15){
                    System.out.println("Turno 1");
                    System.out.println("El conductor "+conductor.getNombre()+" "+conductor.getApellidos()+" llevará al cliente "+cliente.getNombre()+" "
                    +cliente.getApellidos()+" con el vehiculo "+cliente.getV().getMatricula()+" marca="+cliente.getV().getMarca()+" modelo="+cliente.getV().getModelo());
                }else if(conductor.getTurno() == 2 && cliente.getHoraLlegada()>=16 && cliente.getHoraLlegada()<=24){
                    System.out.println("Turno 2");
                    System.out.println("El conductor "+conductor.getNombre()+" "+conductor.getApellidos()+" llevará al cliente "+cliente.getNombre()+" "
                            +cliente.getApellidos()+" con el vehiculo "+cliente.getV().getMatricula()+" marca="+cliente.getV().getMarca()+" modelo="+cliente.getV().getModelo());
                }else if(conductor.getTurno() == 3 && cliente.getHoraLlegada()>=0 && cliente.getHoraLlegada()<=7){
                    System.out.println("Turno 3");
                    System.out.println("El conductor "+conductor.getNombre()+" "+conductor.getApellidos()+" llevará al cliente "+cliente.getNombre()+" "
                            +cliente.getApellidos()+" con el vehiculo "+cliente.getV().getMatricula()+" marca="+cliente.getV().getMarca()+" modelo="+cliente.getV().getModelo());
                }
            }
        }
    }


    private void menu() {
        System.out.println("1. Leer conductores");
        System.out.println("2. Dar de alta cliente");
        System.out.println("3. Guardar clientes");
        System.out.println("4. Leer clientes");
        System.out.println("5. Generar tickets");
        System.out.println("6. Imprimir turno de entrega");
        System.out.println("7. Salir");
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Aparcamiento aparcamiento = new Aparcamiento();
        Scanner sc = new Scanner(System.in);
        //Pruebas
        Coche v1 = new Coche("4567-BJK", "Blanco","Opel","Corsa",5);
        Cliente c1 = new Cliente("11111111H","Mario","Lopez", 24, "Calle Mayor", "mariolopez@ribera.es",7, 3, v1);
        aparcamiento.clientesAparcamiento.add(c1);//!para probar directamente las opciones 3 y 4

        int opcion;

        do {
            aparcamiento.menu();
            System.out.println("Dime la opcion que quieres");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    aparcamiento.leerConductores();
                    break;
                case 2:
                    aparcamiento.darAltaCliente();
                    break;
                case 3:
                    aparcamiento.guardarClientes();
                    break;
                case 4:
                    System.out.println("Se perderán los datos que no hayan sido guardados. ¿Seguro?");
                    System.out.println("A. Sí. B. No");
                    String decision = sc.next();
                    if (decision.equalsIgnoreCase("A")) {
                        aparcamiento.leerClientes();
                        break;
                    } else {
                        break;
                    }
                case 5:
                    aparcamiento.generarTickets();
                    break;
                case 6:
                    aparcamiento.imprimirTurnos();
                    break;
            }}while (opcion!=7);


        sc.close();
}
}
