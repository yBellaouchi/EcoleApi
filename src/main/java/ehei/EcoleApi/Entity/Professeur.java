package ehei.EcoleApi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Professeur {
	@Id @GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private String cin;
       @ManyToOne
	@JoinColumn(name="idMatiere")
	  private Matiere matiere;
	public Professeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Professeur(int id, String nom, String prenom, String cin, Matiere matiere) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.matiere = matiere;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
       
}
