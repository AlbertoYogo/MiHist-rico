package gruposYcanciones;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class loginAdmin extends JFrame {

	private JPanel contentPane;
	static loginAdmin frame2;
	private JTextField duracionField;
	private JTextArea textArea;
	private JTextField grupoField;
	private ArrayList<Cancion> canciones;
	private ArrayList<Grupo> grupos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 = new loginAdmin();
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
	public loginAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(193, 23, 231, 227);
		contentPane.add(textArea);
		
		JButton consultarGrupos = new JButton("Consultar canciones:");
		consultarGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String nombre_grupo=grupoField.getText();
				boolean hayCancion=false;
				canciones=new ArrayList<>();
				grupos=new ArrayList<>();
				try {
					cargarCanciones();
					cargarGrupos();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!nombre_grupo.equals("")) {
		
					for (Grupo grupo : grupos) {
						if(grupo.getNombre().equals(nombre_grupo)) {
							for (Cancion cancion : canciones) {
								if(grupo.getCodigo()==cancion.getCodigo()) {
									textArea.append(cancion.getNombre_cancion()+"\n");
									hayCancion=true;
								}
							}
						}
					}
					
					if (!hayCancion) {
						JOptionPane.showMessageDialog(null, "No hay ninguna canción para este grupo",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No has introducido ningún grupo",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}

			private void cargarGrupos() throws FileNotFoundException {
				File fichero=new File("grupos.csv");
				Scanner entrada=new Scanner(fichero);
				String linea=entrada.nextLine();
				String partido[];
				
				while(entrada.hasNext()) {
					linea=entrada.nextLine();
					partido=linea.split(";");
					grupos.add(new Grupo(Integer.parseInt(partido[0]), partido[1], Integer.parseInt(partido[2]), partido[3]));
					
				}
				
			}

			private void cargarCanciones() throws FileNotFoundException {
				File fichero=new File("canciones.csv");
				Scanner entrada=new Scanner(fichero);
				String linea=entrada.nextLine();
				String partido[];
				
				while(entrada.hasNext()) {
					linea=entrada.nextLine();
					partido=linea.split(";");
					canciones.add(new Cancion(Integer.parseInt(partido[0]), partido[1], partido[2], Integer.parseInt(partido[3]), Integer.parseInt(partido[4])));
					
				}
				
			}
		});
		consultarGrupos.setBounds(10, 55, 173, 54);
		contentPane.add(consultarGrupos);
		
		duracionField = new JTextField();
		duracionField.setBounds(10, 149, 173, 20);
		contentPane.add(duracionField);
		duracionField.setColumns(10);
		
		JLabel duracionLabel = new JLabel("Duraci\u00F3n aproximada:");
		duracionLabel.setBounds(10, 130, 173, 14);
		contentPane.add(duracionLabel);
		
		JButton crearPlaylist = new JButton("Crear lista de reproducci\u00F3n");
		crearPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				if(!duracionField.getText().equals("")) {
					int duracion=Integer.parseInt(duracionField.getText());
					int lista=0;
					String user=Principal.userField.getText();
					String genero=obtenerGenero(user);
					canciones=new ArrayList<>();
					grupos=new ArrayList<>();
					try {
						cargarCanciones();
						cargarGrupos();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//Buscando canciones de forma continuada.
						/*for (Cancion cancion : canciones) {
							for (Grupo grupo : grupos) {
								if(grupo.getCodigo()==cancion.getCodigo() & grupo.getTipo().equals(genero) & lista<duracion) {
									textArea.append(cancion.getNombre_cancion()+" ("+cancion.getMinutos()+").\n");
									lista=lista+cancion.getMinutos();
								}
							}
						}	*/
					
					//Buscando canciones de forma aleatoria.
					while(lista<duracion) {
						int cancion=(int)(Math.random()*canciones.size()-1);
						for (Grupo grupo : grupos) {
							if(grupo.getCodigo()==canciones.get(cancion).getCodigo() & grupo.getTipo().equals(genero) & lista<duracion) {
								textArea.append(canciones.get(cancion).getNombre_cancion()+" ("+canciones.get(cancion).getMinutos()+").\n");
								lista=lista+canciones.get(cancion).getMinutos();
							}
						}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Debes introducir una duración aproximada",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				}
					
			}
			
			private String obtenerGenero(String user) {
				String genero="";
				try {
					ResultSet rset=BD.getInstance().consultaBD("SELECT LOGIN,TIPO_MUSICA FROM USUARIOS");
					while(rset.next()) {
						if(rset.getString(1).equals(user)) {
							genero=rset.getString(2);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return genero;
			}

			private void cargarGrupos() throws FileNotFoundException {
				File fichero=new File("grupos.csv");
				Scanner entrada=new Scanner(fichero);
				String linea=entrada.nextLine();
				String partido[];
				
				
				while(entrada.hasNext()) {
					linea=entrada.nextLine();
					partido=linea.split(";");
					grupos.add(new Grupo(Integer.parseInt(partido[0]), partido[1], Integer.parseInt(partido[2]), partido[3]));
					
				}
				
			}

			private void cargarCanciones() throws FileNotFoundException {
				File fichero=new File("canciones.csv");
				Scanner entrada=new Scanner(fichero);
				String linea=entrada.nextLine();
				String partido[];
				
				while(entrada.hasNext()) {
					linea=entrada.nextLine();
					partido=linea.split(";");
					canciones.add(new Cancion(Integer.parseInt(partido[0]), partido[1], partido[2], Integer.parseInt(partido[3]), Integer.parseInt(partido[4])));
					
				}
			}
		});
		
		crearPlaylist.setBounds(10, 180, 173, 43);
		contentPane.add(crearPlaylist);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 251, 231, -240);
		contentPane.add(scrollPane);
		
		JLabel grupoLabel = new JLabel("Nombre del grupo:");
		grupoLabel.setBounds(10, 11, 142, 14);
		contentPane.add(grupoLabel);
		
		grupoField = new JTextField();
		grupoField.setBounds(10, 25, 173, 20);
		contentPane.add(grupoField);
		grupoField.setColumns(10);
	}
}
