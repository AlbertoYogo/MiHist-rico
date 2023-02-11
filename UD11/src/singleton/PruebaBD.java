package singleton;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PruebaBD {

	public static void main(String[] args) {
		//BD miconexion=BD.getInstance();
		//BD miconexion2=BD.getInstance();
				
		
		BD.getInstance().setCadenaConexion("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		BD.getInstance().setUsuario("JARDINERIA");
		BD.getInstance().setPass("1");
		
		try {
			ResultSet rset=BD.getInstance().consultaBD("select count(*) from pedidos");
			while(rset.next()) {
				System.out.println(rset.getString(1));
			}
			BD.getInstance().cerrarConsulta();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
