package exam;

/**
 *
 * @author Mohamed Selim Maazouz
 */
public class Etudiant {
	private long cin;
	private String nom;
	private String prenom;
	
	public Etudiant(long cin,String nom,String prenom) {
		this.cin=cin;
		this.nom=nom;
		this.prenom=prenom;
	}

	public long getCin() {
		return cin;
	}

	public void setCin(long cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

}
