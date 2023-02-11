package Clínica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DNI extends JFrame {

	private JPanel contentPane;
	public static DNI frame2;
	private JTextField DNItext;
	private String identificacion;

	public JTextField getDNItext() {
		return DNItext;
	}

	public void setDNItext(JTextField dNItext) {
		DNItext = dNItext;
	}
	
	

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new DNI();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DNI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 185, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setDNItext(new JTextField());
		getDNItext().setBounds(10, 56, 124, 20);
		contentPane.add(getDNItext());
		getDNItext().setColumns(10);
		
		JLabel dameDNI = new JLabel("Dame tu DNI:");
		dameDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dameDNI.setBounds(10, 31, 108, 14);
		contentPane.add(dameDNI);
		
		JButton DNIboton = new JButton("Enviar DNI");
		DNIboton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DNI.frame2.setIdentificacion(DNI.frame2.getDNItext().getText());
				frame2.setVisible(false);
				atenderCliente.frame3.setVisible(true);
			}
		});
		DNIboton.setBounds(10, 97, 124, 23);
		contentPane.add(DNIboton);
	}

}
