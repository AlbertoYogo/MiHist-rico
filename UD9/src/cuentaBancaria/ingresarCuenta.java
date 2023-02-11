package cuentaBancaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ingresarCuenta extends JFrame {

	private JPanel contentPane;
	static ingresarCuenta frame2;
	private JTextField ingresarCuentaText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new ingresarCuenta();
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
	public ingresarCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ingresarCuentaLabel = new JLabel("Dime cuanto dinero vas a ingresar");
		ingresarCuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ingresarCuentaLabel.setBounds(56, 29, 251, 13);
		contentPane.add(ingresarCuentaLabel);
		
		ingresarCuentaText = new JTextField();
		ingresarCuentaText.setBounds(66, 52, 196, 19);
		contentPane.add(ingresarCuentaText);
		ingresarCuentaText.setColumns(10);
		
		JButton ingresarBoton = new JButton("Ingresar saldo");
		ingresarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double saldo;
				saldo=Double.parseDouble(Principal.frame1.getTextCuenta().getText())+Double.parseDouble(ingresarCuentaText.getText());
				Principal.frame1.getTextCuenta().setText(String.valueOf(saldo));
				Principal.frame1.setVisible(true);
				frame2.setVisible(false);
				ingresarCuentaText.setText("");
			}
		});
		ingresarBoton.setBounds(265, 157, 121, 21);
		contentPane.add(ingresarBoton);
	}

}
