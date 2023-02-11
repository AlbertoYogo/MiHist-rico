package Clínica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazClinica extends JFrame implements EntradasUsuario {

	private JPanel contentPane;
	public static interfazClinica frame1;
	public static JTextArea textArea;
	private ArrayList<Profesionales> medicos;
	private LinkedList<Pacientes> pacientes;

	@Override
	public boolean isNum(String n) {
		return n.matches("[0-9]*");
	}
	
	public interfazClinica(int n) {
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new interfazClinica();
					frame1.setVisible(true);
					DNI.frame2 = new DNI();
					DNI.frame2.setVisible(false);
					atenderCliente.frame3= new atenderCliente();
					atenderCliente.frame3.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfazClinica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonListado = new JButton("Listado pacientes");
		botonListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");;
				interfazClinica c=new interfazClinica(0);
				c.cargaInicial();
				for (Profesionales medico : c.medicos) {
					textArea.append("*****************  " +medico.getEspecialidad()+ "  *****************\n");
					textArea.append("La lista de pacientes de Dr/Dra " +medico.getNombre()+" "+medico.getApellidos()+" es: \n");
					for (Pacientes paciente : c.pacientes) {
						if(paciente.getCita().equals(medico.getEspecialidad())) {
							textArea.append("        "+ paciente.getNombre()+" "+paciente.getApellidos()+"\n");
							textArea.append("");
						}
					}
				}
			}
		});
		botonListado.setBounds(10, 11, 123, 38);
		contentPane.add(botonListado);
		
		JButton botonCargarHistorias = new JButton("Cargar historias");
		botonCargarHistorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");;
				interfazClinica c=new interfazClinica(0);
				c.cargaInicial();
				for (int i = 0; i < c.pacientes.size(); i++) {
					String filename="Historia"+c.pacientes.get(i).getDNI()+".txt";
					File fichero=new File(filename);
					if(fichero.exists()) {

						String historia="";
						Scanner entrada;
						try {
							entrada = new Scanner(fichero);
								textArea.append("Existe " +filename+"\n");
								while(entrada.hasNext()) {
									historia=historia+entrada.nextLine()+"\n";
								}
								c.pacientes.get(i).setHistoria(historia);
								entrada.close();
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
					}
				}
			}
			
		});
		botonCargarHistorias.setBounds(175, 11, 123, 38);
		contentPane.add(botonCargarHistorias);
		
		JButton botonAtenderPaciente = new JButton("Atender paciente");
		botonAtenderPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");;
				interfazClinica c=new interfazClinica(0);
				c.cargaInicial();
				DNI.frame2.setVisible(true);
				
			}
		});
		botonAtenderPaciente.setBounds(342, 11, 123, 38);
		contentPane.add(botonAtenderPaciente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 455, 213);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
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
