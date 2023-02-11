package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBDD {

	public static void main(String[] args) throws SQLException {
		//1. Crear el driver.
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		//2. Crear la conexión a la BDD Oracle.
			//Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "jardineria_DAM", "1");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "jardineria_DAM", "1");
		
		//3. Crear y ejecutar la consulta.
		Statement stmt= conn.createStatement();
		
		ResultSet rset= stmt.executeQuery("select codigocliente, nombrecliente from clientes");
		
		
		//4. Recorrer la tabla.
		while(rset.next()) {
			System.out.println(rset.getString(1)+" "+rset.getString(2));
		}
		
		//5 Cerrar la conexión.
		stmt.close();
		
		/*En pocas palabras (Puntos del 1 al 3):
		 * consiste en crear un driver
		 * luego la conexión
		 * Después una sentencia
		 * y después guardar el resultado de l setencia.*/
	}
}
