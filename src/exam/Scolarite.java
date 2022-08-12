/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author Sam
 */
public class Scolarite {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

	}
	
	public void Menu() {
		System.out.println("1) Ajouter étudiant\r\n"
				+ "2) Rechercher étudiant\r\n"
				+ "3) Afficher les étudiants\r\n"
				+ "4) Supprimer étudiant\r\n"
				+ "5) Quitter");
	}
	
	public void AjouterEtudiant(Etudiant e) {
		Scanner read=new Scanner(System.in);
		System.out.println("Saisir les informations de l’étudiant ");
		
		System.out.print("CNI : ");
		e.setCin(read.nextLong());System.out.println();
		
		System.out.print("NOM : ");
		e.setNom(read.nextLine());System.out.println();
		
		System.out.print("PRENOM : ");
		e.setPrenom(read.nextLine());System.out.println();
		
		JDBCEtudiant jdbc =new JDBCEtudiant();
		jdbc.connexion();
		int a=jdbc.MiseaAjour("INSERT INTO ETUDIANT VALUES ("+e.getCin()+","+e.getNom()+","+e.getPrenom()+")");
		
	}
	
	public void RechercherEtudiant(long cin) {
		try {
			JDBCEtudiant jdbc =new JDBCEtudiant();
			jdbc.connexion();
			Statement stm = jdbc.cx.createStatement();
		
			ResultSet rst=stm.executeQuery("SELECT * FROM ETUDIANT WHERE CNI="+cin);
			
			System.out.println("CIN: "+rst.getString("CIN")+"\tNOM: "+rst.getString("NOM")+"\tPRENOM: "+rst.getString("PRENOM") );
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	public void AfficherEtudiants(){
		JDBCEtudiant jdbc =new JDBCEtudiant();
		jdbc.connexion();
		jdbc.Afficher();
	}
	
	public void SupprimerEtudiant(long cin) {
		JDBCEtudiant jdbc =new JDBCEtudiant();
		jdbc.connexion();
		int a=jdbc.MiseaAjour("DELETE FROM ETUDIANT WHERE CIN="+cin);
		
	}
	
	public void Quitter() {
		System.out.println("goodbay!!!!!");
		
	}
}

