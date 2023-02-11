package cuentaBancaria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	static Principal frame1;
	private JTextField textCuenta;
	private JTextField textSaldo;
	public JTextField getTextCuenta() {
		return textCuenta;
	}

	public void setTextCuenta(JTextField textCuenta) {
		this.textCuenta = textCuenta;
	}

	public JTextField getTextSaldo() {
		return textSaldo;
	}

	public void setTextSaldo(JTextField textSaldo) {
		this.textSaldo = textSaldo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new Principal();
					frame1.setVisible(true);
					ingresarCuenta.frame2 = new ingresarCuenta();
					ingresarCuenta.frame2.setVisible(false);
					ingresarSaldo.frame3 = new ingresarSaldo();
					ingresarSaldo.frame3.setVisible(false);
					retirarCuenta.frame4 = new retirarCuenta();
					retirarCuenta.frame4.setVisible(false);
					retirarSaldo.frame5 = new retirarSaldo();
					retirarSaldo.frame5.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ingresarCuentaBoton = new JButton("Ingresar en cuenta");
		ingresarCuentaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				ingresarCuenta.frame2.setVisible(true);
			}
		});
		ingresarCuentaBoton.setBounds(10, 10, 149, 21);
		contentPane.add(ingresarCuentaBoton);
		
		JButton sacarCuenta = new JButton("Sacar dinero de la cuenta");
		sacarCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				retirarCuenta.frame4.setVisible(true);
			}
		});
		sacarCuenta.setBounds(209, 10, 194, 21);
		contentPane.add(sacarCuenta);
		
		JButton ingresarTarjetaBoton = new JButton("Ingresar en tarjeta");
		ingresarTarjetaBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				ingresarSaldo.frame3.setVisible(true);
			}
		});
		ingresarTarjetaBoton.setBounds(10, 61, 149, 21);
		contentPane.add(ingresarTarjetaBoton);
		
		JButton sacarTarjeta = new JButton("Sacar dinero de la tarjeta");
		sacarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				retirarSaldo.frame5.setVisible(true);
			}
		});
		sacarTarjeta.setBounds(209, 61, 194, 21);
		contentPane.add(sacarTarjeta);
		
		JButton transferir = new JButton("transferir de cuenta a tarjeta");
		transferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double saldo;
				saldo=Double.parseDouble(textCuenta.getText())+Double.parseDouble(textSaldo.getText());
				textSaldo.setText(String.valueOf(saldo));
				textCuenta.setText("0.0");
			}
		});
		transferir.setBounds(102, 92, 194, 35);
		contentPane.add(transferir);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		salir.setBounds(318, 207, 85, 21);
		contentPane.add(salir);
		
		JLabel saldoCuenta = new JLabel("Saldo cuenta:");
		saldoCuenta.setBounds(25, 163, 78, 13);
		contentPane.add(saldoCuenta);
		
		JLabel saldoTarjeta = new JLabel("Saldo tarjeta:");
		saldoTarjeta.setBounds(25, 195, 78, 13);
		contentPane.add(saldoTarjeta);
		
		textCuenta = new JTextField();
		textCuenta.setText("0");
		textCuenta.setEditable(false);
		textCuenta.setBounds(124, 161, 158, 16);
		contentPane.add(textCuenta);
		textCuenta.setColumns(10);
		
		textSaldo = new JTextField();
		textSaldo.setText("0");
		textSaldo.setEditable(false);
		textSaldo.setColumns(10);
		textSaldo.setBounds(124, 193, 158, 16);
		contentPane.add(textSaldo);
	}
}
