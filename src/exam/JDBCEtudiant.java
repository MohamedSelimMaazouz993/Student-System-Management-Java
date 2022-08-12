/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;


/**
 *
 * @author Mohamed Selim Maazouz
 */
import java.sql.*;
public class JDBCEtudiant {
	
	private String url;
	private String utilisateur;
	private String motdepasse;
	public Connection cx;
	
	
	
	


	public boolean SQLService(String pilote, String url, String utilisteur,String motdepasse) {
		url = "jdbc:mysql://localhost:3306/etudiant";
		utilisateur="root";
		motdepasse="";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
                    // TODO Auto-generated catch block

		}
		
			System.out.println("connexion");
			try {
				cx = DriverManager.getConnection(url,utilisateur,motdepasse);
				return true;
			} catch (SQLException e) {
				// TODO: handle 
				return false;
			}
		
		}
		
	
	
	public boolean connexion() {
		System.out.println("connexion");
		try {
			cx = DriverManager.getConnection(url,utilisateur,motdepasse);
			return true;
		} catch (SQLException e) {
			// TODO: handle 
			return false;
		}
	
	}
	public void deconnexion() {
		try {
			cx.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	public int MiseaAjour(String sql) {
		try {
			Statement stm = cx.createStatement();
			
			return stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO: handle exception
			return -1;
		}
		
		
	}
	public void Afficher() {
		try {
			Statement stm = cx.createStatement();
		
			ResultSet rst=stm.executeQuery("SELECT * FROM ETUDIANT ORDER BY NOM,PRENOM");
			while (rst.next()) {
				System.out.println("CNI: "+rst.getString("CNI")+"\tNOM: "+rst.getString("NOM")+"\tPRENOM: "+rst.getString("PRENOM") );
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			
		}
	}

}
