package gruposYcanciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
	private static BD miInstancia=null;
	private static boolean permitirInstancianueva;
	private String cadenaConexion;
	private String usuario;
	private String pass;
	private Connection conn;
	private Statement stmt;
	
	BD() throws Exception{
		if(!permitirInstancianueva) {
			throw new Exception("No se puede crear otro objeto de la clase. Usa getInstance");
		}
		
	}
	//La primera y �nica vez que se crea
	//F�jate que se inicializa a nulo al declarar la variable de la clase
	public static BD getInstance() {
		if(miInstancia==null) {
			permitirInstancianueva=true;
			try {
				miInstancia=new BD();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			permitirInstancianueva=false;
		}
		
		return miInstancia;
	}
	//Devuelve el conjunto de tuplas de la consulta
	public ResultSet consultaBD(String consulta) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		conn=DriverManager.getConnection(cadenaConexion, usuario, pass);
		stmt=conn.createStatement();
		ResultSet rset=stmt.executeQuery(consulta);
		
		return rset;
	 }
	
	public void cerrarConsulta() throws SQLException {
		stmt.close();
	 }

	//Getters y Setters
	public String getCadenaConexion() {
		return cadenaConexion;
	}
	public void setCadenaConexion(String cadenaConexion) {
		this.cadenaConexion = cadenaConexion;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public Statement getStmt() {
		return stmt;
	}
	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
	
}
