package gruposYcanciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cancion {

	private int codigo;
	private String disco;
	private String nombre_cancion;
	private int minutos;
	private int segundos;
	
	public Cancion(int codigo, String disco, String nombre_cancion, int minutos, int segundos) {
		this.codigo = codigo;
		this.disco = disco;
		this.nombre_cancion = nombre_cancion;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	
	public Cancion() {
		this.codigo = 0;
		this.disco = "";
		this.nombre_cancion = "";
		this.minutos = 0;
		this.segundos = 0;
	}

	static void crearCSV() throws SQLException, FileNotFoundException {
		BD.getInstance().setCadenaConexion("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		BD.getInstance().setUsuario("examen");
		BD.getInstance().setPass("examen");
		
		File fichero=new File("canciones.csv");
		PrintWriter salida=new PrintWriter(fichero);
		ResultSet rset=BD.getInstance().consultaBD("SELECT * FROM CANCIONES");
		
		salida.println("CODIGO_GRUPO;DISCO;TITULO;MINUTOS;SEGUNDOS");
		while(rset.next()) {
			salida.println(rset.getString(1)+";"+rset.getString(2)+";"+rset.getString(3)+";"+rset.getString(4)+";"+rset.getString(5));
		}
		
		BD.getInstance().cerrarConsulta();
		salida.flush();
		salida.close();
		for (int i = 0; i < 10; i++) {
			
		}
		
	}
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDisco() {
		return disco;
	}

	public void setDisco(String disco) {
		this.disco = disco;
	}

	public String getNombre_cancion() {
		return nombre_cancion;
	}

	public void setNombre_cancion(String nombre_cancion) {
		this.nombre_cancion = nombre_cancion;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	@Override
	public String toString() {
		return "Cancion [codigo=" + codigo + ", disco=" + disco + ", nombre_cancion=" + nombre_cancion + ", minutos="
				+ minutos + ", segundos=" + segundos + "]";
	}
}
