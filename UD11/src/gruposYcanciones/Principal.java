package gruposYcanciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	static Principal frame1;
	static JTextField userField;
	static JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 = new Principal();
					frame1.setVisible(true);
					loginAdmin.frame2= new loginAdmin();
					loginAdmin.frame2.setVisible(false);
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
		
		JLabel userText = new JLabel("Usuario:");
		userText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userText.setBounds(105, 69, 68, 20);
		contentPane.add(userText);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userField.setBounds(196, 71, 117, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel claveText = new JLabel("Clave:");
		claveText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		claveText.setBounds(105, 117, 46, 14);
		contentPane.add(claveText);
		
		JButton entrarBoton = new JButton("Entrar");
		entrarBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BD.getInstance().setCadenaConexion("jdbc:oracle:thin:@localhost:1521/XEPDB1");
				BD.getInstance().setUsuario("examen");
				BD.getInstance().setPass("examen");
				String user=userField.getText();
				String pass=passwordField.getText();
				String tipo="";
				try {
					ResultSet rset=BD.getInstance().consultaBD("Select login,password, tipo_usuario from usuarios where login='"+user+"' and password='"+pass+"'");
					while (rset.next()) {
						tipo=rset.getString(3);
						if(tipo.equals("A") ) {
							frame1.setVisible(false);
							boolean salir=false;
							int opcion=0;
							Scanner Sc=new Scanner(System.in);
							while(!salir) {
								menuAdmin();
								opcion=Sc.nextInt();
								
								switch (opcion) {
								case 1: altaGrupo();
									break;
								case 2: bajaGrupo();
									break;
								case 3: bajaCancion();
									break;
								case 4: altaCancion();
									break;
								case 5: try {
										consultarUsuarios();
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									break;
								case 6: try {
										Grupo.crearCSV();
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									break;
								case 7: try {
										Cancion.crearCSV();
									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									break;
								case 8: salir=true;
									break;
								}
							}
						}
						else {
							if(tipo.equals("U")) {
								frame1.setVisible(false);
								loginAdmin.frame2.setVisible(true);
							}
							else {
							JOptionPane.showMessageDialog(null, "Contraseña incorrecta",
									"ERROR", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
					BD.getInstance().cerrarConsulta();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			private void consultarUsuarios() throws FileNotFoundException, SQLException {
				File fichero=new File("fichero.txt");
				PrintWriter salida=new PrintWriter(fichero);
				ResultSet rset=BD.getInstance().consultaBD("SELECT * FROM USUARIOS");
				while(rset.next()) {
					salida.println("Usuario: " +rset.getString(1)+", contraseña: " +rset.getString(2)+", tipo de usuario: "+rset.getString(3)+", DNI: "+rset.getString(4));
				}
				
				BD.getInstance().cerrarConsulta();
				salida.flush();
				salida.close();
			}

			private void altaCancion() {
				Scanner Sc=new Scanner(System.in);
				System.out.println("Dame el código de grupo");
				int codigo=Sc.nextInt();
				System.out.println("Dame el nombre del disco");
				String disco=Sc.nextLine();
				Sc.nextLine();
				System.out.println("Dame el nombre de la canción");
				String nombre_cancion=Sc.nextLine();
				Sc.nextLine();
				System.out.println("Minutos de la canción");
				int minutos=Sc.nextInt();
				System.out.println("Segundos de la canción");
				int segundos=Sc.nextInt();
				try {
					BD.getInstance().consultaBD("INSERT INTO CANCIONES VALUES ("+"'"+codigo+"',"+"'"+disco+"',"+"'"+nombre_cancion+"',"+"'"+minutos+"',"+"'"+segundos+"'"+")");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			private void bajaCancion() throws SQLException {
				Scanner Sc=new Scanner(System.in);
				System.out.println("Dame el nombre de la canción");
				String nombre_cancion=Sc.nextLine();
				Sc.nextLine();
				BD.getInstance().consultaBD("DELETE FROM CANCIONES WHERE TITULO='"+nombre_cancion+"'");
				BD.getInstance().cerrarConsulta();	
				
			}

			private void bajaGrupo() throws SQLException {
				Scanner Sc=new Scanner(System.in);
				System.out.println("Dame el código de grupo");
				int codigo=Sc.nextInt();
				BD.getInstance().consultaBD("DELETE FROM CANCIONES WHERE CODIGO_GRUPO='"+codigo+"'");
				BD.getInstance().cerrarConsulta();	
				BD.getInstance().consultaBD("DELETE FROM GRUPOS WHERE CODIGO='"+codigo+"'");
				BD.getInstance().cerrarConsulta();	
				
			}

			private void altaGrupo() {
				Scanner Sc= new Scanner(System.in);
				System.out.println("Dame el código del grupo");
				int codigo=Sc.nextInt();
				System.out.println("Dame el nombre");
				String nombre=Sc.next();
				Sc.nextLine();
				System.out.println("Dame el año");
				int año=Sc.nextInt();
				System.out.println("Dame el género del grupo");
				String genero=Sc.next();
				Sc.nextLine();
				try {
					BD.getInstance().consultaBD("INSERT INTO GRUPOS VALUES ("+"'"+codigo+"',"+"'"+nombre+"',"+"'"+año+"',"+"'"+genero+"'"+")");
					BD.getInstance().cerrarConsulta();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}

			private void menuAdmin() {
				System.out.println("1. Dar de alta nuevo grupo en la BD.");
				System.out.println("2. Dar de baja un grupo borrando todas sus canciones.");
				System.out.println("3. Dar de baja una canción de un grupo");
				System.out.println("4. Dar de alta canción de un grupo.");
				System.out.println("5. Consultar usuarios.");
				System.out.println("6. Generar grupos.csv:");
				System.out.println("7. Generar canciones.csv:");
				System.out.println("8. Salir");
				System.out.println("Elige una opción: ");
			}
		});
		entrarBoton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		entrarBoton.setBounds(105, 164, 89, 23);
		contentPane.add(entrarBoton);
		
		JButton salirBoton = new JButton("Salir");
		salirBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salirBoton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salirBoton.setBounds(224, 164, 89, 23);
		contentPane.add(salirBoton);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(196, 116, 117, 20);
		contentPane.add(passwordField);
	}

}
