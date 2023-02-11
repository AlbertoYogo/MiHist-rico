package gruposYcanciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Grupo {
	private int codigo;
	private String nombre;
	private int año;
	private String tipo;
	
	public Grupo(int codigo, String nombre, int año, String tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.año = año;
		this.tipo = tipo;
	}
	
	public Grupo() {
		this.codigo = 0;
		this.nombre = "";
		this.año = 0;
		this.tipo = "";
	}
	
	static void crearCSV() throws SQLException, FileNotFoundException {
		BD.getInstance().setCadenaConexion("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		BD.getInstance().setUsuario("examen");
		BD.getInstance().setPass("examen");
		
		File fichero=new File("grupos.csv");
		PrintWriter salida=new PrintWriter(fichero);
		ResultSet rset=BD.getInstance().consultaBD("SELECT * FROM GRUPOS");
		
		salida.println("CODIGO;NOMBRE;AÑO;TIPO_MÚSICA");
		while(rset.next()) {
			salida.println(rset.getString(1)+";"+rset.getString(2)+";"+rset.getString(3)+";"+rset.getString(4));
		}
		
		BD.getInstance().cerrarConsulta();
		salida.flush();
		salida.close();
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Grupo [codigo=" + codigo + ", nombre=" + nombre + ", año=" + año + ", tipo=" + tipo + "]";
	}
}
