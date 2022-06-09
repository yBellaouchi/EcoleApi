package ehei.EcoleApi.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity 
public class Etudiant implements Serializable {
	@Id @GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String cin;
    private int age;
   @ManyToOne
	@JoinColumn(name="idFiliere")
	  private Filiere Filiere;
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
	return id;
}
@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", age=" + age
				+ ", Filiere=" + Filiere + "]";
	}
public Etudiant(Long id, String nom, String prenom, String cin, int age, ehei.EcoleApi.Entity.Filiere filiere) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.age = age;
	this.Filiere = filiere;
}
public Etudiant(String nom, String prenom, String cin, int age, ehei.EcoleApi.Entity.Filiere filiere) {
	// TODO Auto-generated constructor stub
	this.nom = nom;
	this.prenom = prenom;
	this.cin = cin;
	this.age = age;
	this.Filiere = filiere;
}
public void setId(Long id) {
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Filiere getFiliere() {
	return Filiere;
}
public void setFiliere(Filiere filiere) {
	this.Filiere = filiere;
}
}
	