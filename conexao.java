package testeBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	conexao(){
		url="jdbc:postgresql://localhost:5432/hortifrut";
		usuario="postgres";
		senha="123";
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url, usuario, senha);
			System.out.println("OK");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public int conectaSQL(String sql) {
		try {
			Statement stm= con.createStatement();
			int res= stm.executeUpdate(sql);
			con.close();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	public ResultSet Busca(String sql) {
		try {
			Statement stm= con.createStatement();
			ResultSet rs= stm.executeQuery(sql);
			con.close();
			return rs;
		} catch (Exception e) {
			return null;
		}
	}

}