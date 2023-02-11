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

public class ingresarSaldo extends JFrame {

	private JPanel contentPane;
	static ingresarSaldo frame3;
	private JTextField ingresarSaldoText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame3 = new ingresarSaldo();
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
	public ingresarSaldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ingresarSaldoLabel = new JLabel("Dime cuanto dinero vas a ingresar");
		ingresarSaldoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ingresarSaldoLabel.setBounds(66, 29, 264, 13);
		contentPane.add(ingresarSaldoLabel);
		
		ingresarSaldoText = new JTextField();
		ingresarSaldoText.setBounds(66, 52, 204, 19);
		contentPane.add(ingresarSaldoText);
		ingresarSaldoText.setColumns(10);
		
		JButton ingresarSaldoBoton = new JButton("Ingresar en tarjeta");
		ingresarSaldoBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double saldo;
				saldo=Double.parseDouble(Principal.frame1.getTextSaldo().getText())+Double.parseDouble(ingresarSaldoText.getText());
				Principal.frame1.getTextSaldo().setText(String.valueOf(saldo));
				Principal.frame1.setVisible(true);
				frame3.setVisible(false);
				ingresarSaldoText.setText("");
			}
		});
		ingresarSaldoBoton.setBounds(259, 169, 133, 21);
		contentPane.add(ingresarSaldoBoton);
	}

}
