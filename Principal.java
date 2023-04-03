package testeBD;

import java.sql.ResultSet;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		conexao con= new conexao();
		String sql= "INSERT into produto (id_produto,nome,peso) values(9,'melao',0.50)";
		int res=con.conectaSQL(sql);
		if(res>0) {
			System.out.println("OK");
		}else {
			System.out.println("Error..");
		}
		
		int j,k;

		
	    con= new conexao();
		sql="Select * from produto";
		ResultSet rs= con.Busca(sql);
		try {
			while(rs.next()) {
				
				String nome= rs.getString("nome");
				System.out.println(nome);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 con= new conexao();
			sql= "DELETE FROM produto WHERE id_produto=9";
			 res=con.conectaSQL(sql);
			if(res>0) {
				System.out.println("OK");
			}else {
				System.out.println("Error..");
			}
		    con= new conexao();
			sql="Select * from produto";
		     rs= con.Busca(sql);
			try {
				while(rs.next()) {
					
					String nome= rs.getString("nome");
					System.out.println(nome);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		
		System.out.println("----------------consultas----------------------");
		con= new conexao();
		
		  sql="Select * from funcionario";
		ResultSet rs2= con.Busca(sql);
		try {
			while(rs2.next()) {
				
				String nome= rs2.getString("nomefunc");
				System.out.println(nome);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		con= new conexao();
		
		 sql="Select * from cliente";
		ResultSet rs3= con.Busca(sql);
		try {
			while(rs3.next()) {
				
				String nome= rs3.getString("endereco");
				System.out.println(nome);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Scanner sn= new Scanner(System.in);
		int i=100;
		while(i>0) {
			System.out.println("Choose a option: ");
			System.out.println("1 - Add new product");
			System.out.println("2 - consult data: ");
			System.out.println("3 - Delete Product: ");
			System.out.println("0 - Quit: ");
			i= sn.nextInt();
			if(i==1){
				System.out.println("Adding product... Enter the ID");
				 con= new conexao();
				 j=sn.nextInt();
				 sql= "INSERT into produto (id_produto) values("+j+")";
				 res=con.conectaSQL(sql);
				if(res>0) {
					System.out.println("OK");
				}else {
					System.out.println("Error..");
				}
				
			}else if(i==2){
				System.out.println("Checking product list...");
			    con= new conexao();
				sql="Select * from produto";
				 rs= con.Busca(sql);
				try {
					while(rs.next()) {
						
						String nome= rs.getString("id_produto");
						System.out.println(nome);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}else if(i==3) {
				System.out.println("Deleting products...");
				System.out.println("Select the ID product");
				 	con= new conexao();
				 	k=sn.nextInt();
					sql= "DELETE FROM produto WHERE id_produto="+k;
					 res=con.conectaSQL(sql);
					if(res>0) {
						System.out.println("OK");
					}else {
						System.out.println("Error..");
					}
			}
			
		}
		
		System.out.println("system off");		
		

	}

}