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

public class retirarSaldo extends JFrame {

	private JPanel contentPane;
	static retirarSaldo frame5;
	private JTextField retirarSaldoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame5 = new retirarSaldo();
					frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public retirarSaldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel retirarSaldoLabel = new JLabel("Dime cuanto dinero vas a retirar:");
		retirarSaldoLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retirarSaldoLabel.setBounds(40, 10, 218, 13);
		contentPane.add(retirarSaldoLabel);
		
		retirarSaldoText = new JTextField();
		retirarSaldoText.setBounds(40, 33, 218, 19);
		contentPane.add(retirarSaldoText);
		retirarSaldoText.setColumns(10);
		
		JButton retirarSaldoBoton = new JButton("Retirar saldo");
		retirarSaldoBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double saldo=Double.parseDouble(retirarSaldoText.getText());
				if(Double.parseDouble(Principal.frame1.getTextSaldo().getText())>=saldo) {
					saldo=Double.parseDouble(Principal.frame1.getTextSaldo().getText())-saldo;
					Principal.frame1.getTextSaldo().setText(String.valueOf(saldo));
					frame5.setVisible(false);
					Principal.frame1.setVisible(true);
					retirarSaldoText.setText("");
				}
				else {
					JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Insuficiente saldo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		retirarSaldoBoton.setBounds(249, 181, 124, 30);
		contentPane.add(retirarSaldoBoton);
	}

}
