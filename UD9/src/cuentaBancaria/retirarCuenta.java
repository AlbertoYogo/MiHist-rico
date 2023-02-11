package cuentaBancaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class retirarCuenta extends JFrame {

	private JPanel contentPane;
	static retirarCuenta frame4;
	private JTextField retirarCuentaText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 = new retirarCuenta();
					frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public retirarCuenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel retirarCuentaLabel = new JLabel("Dime cuanto dinero vas a retirar:");
		retirarCuentaLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retirarCuentaLabel.setBounds(58, 22, 217, 13);
		contentPane.add(retirarCuentaLabel);
		
		retirarCuentaText = new JTextField();
		retirarCuentaText.setBounds(54, 45, 221, 19);
		contentPane.add(retirarCuentaText);
		retirarCuentaText.setColumns(10);
		
		JButton retirarCuentaBoton = new JButton("Retirar dinero");
		retirarCuentaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double saldo=Double.parseDouble(retirarCuentaText.getText());
						if(Double.parseDouble(Principal.frame1.getTextCuenta().getText())>=saldo) {
							saldo=Double.parseDouble(Principal.frame1.getTextCuenta().getText())-saldo;
							Principal.frame1.getTextCuenta().setText(String.valueOf(saldo));
							frame4.setVisible(false);
							Principal.frame1.setVisible(true);
							retirarCuentaText.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Insuficiente saldo", JOptionPane.ERROR_MESSAGE);
						}
			}
		});
		retirarCuentaBoton.setBounds(288, 181, 119, 21);
		contentPane.add(retirarCuentaBoton);
	}

}
