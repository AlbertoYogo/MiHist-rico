package Clínica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class atenderCliente extends JFrame {

	private JPanel contentPane;
	public static atenderCliente frame3;
	private JTextField atenderText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3= new atenderCliente();
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public atenderCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		atenderText = new JTextField();
		atenderText.setBounds(10, 26, 414, 104);
		contentPane.add(atenderText);
		atenderText.setColumns(10);
		
		JButton botonAtender = new JButton("Atender");
		botonAtender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String persona=DNI.frame2.getIdentificacion();
				Clinica c=new Clinica();
				c.cargaInicial();
				c.cargarHistorias();
				for (Pacientes paciente : c.getPacientes()) {
						String historia=paciente.getHistoria()+"\n";

					if(persona.equals(paciente.getDNI())) {
						
						String linea="";
						Scanner escaner=new Scanner(System.in);
						
							linea=atenderText.getText();
							historia=historia+ linea+ "\n";
							if(!linea.equals("Fin")) {
								paciente.setHistoria(historia);
								paciente.GuardarHistoria();
								atenderText.setText("");
							}
							else {
								frame3.setVisible(false);
							}
						
						escaner.close();
					}
				}
			}
		});
		botonAtender.setFont(new Font("Tahoma", Font.PLAIN, 24));
		botonAtender.setBounds(10, 151, 414, 99);
		contentPane.add(botonAtender);
	}

}
