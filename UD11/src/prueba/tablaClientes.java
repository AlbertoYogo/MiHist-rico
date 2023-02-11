package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class tablaClientes {

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "jardineria_DAM", "1");
		
		Statement stmt= conn.createStatement();
		ResultSet rset= stmt.executeQuery("select codigocliente, nombrecontacto, apellidocontacto, telefono from clientes");
		
		File fichero=new File("clientes.html");
		try {
			PrintWriter salida=new PrintWriter(fichero);
			salida.println("<h1>Contactos de clientes</h1>");
			salida.println("<table>");
			salida.println("<tr>");
				salida.println("<th style='border: 1px solid black'>Codigo</th>");
				salida.println("<th style='border: 1px solid black'>Nombre</th>");
				salida.println("<th style='border: 1px solid black'>Apellido</th>");
				salida.println("<th style='border: 1px solid black'>Teléfono</th>");
			salida.println("</tr>");
			
			while(rset.next()) {
				salida.println("<tr>");
					salida.println("<td style='border: 1px solid black'>"+rset.getString(1)+"</td>");
					salida.println("<td style='border: 1px solid black'>"+rset.getString(2)+"</td>");
					salida.println("<td style='border: 1px solid black'>"+rset.getString(3)+"</td>");
					salida.println("<td style='border: 1px solid black'>"+rset.getString(4)+"</td>");
				salida.println("</tr>");
			}
				
			salida.println("</table>");
			
			
			salida.flush();
			salida.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
