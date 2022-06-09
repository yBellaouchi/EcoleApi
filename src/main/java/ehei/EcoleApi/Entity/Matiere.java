package ehei.EcoleApi.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Matiere {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMatiere;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="idFiliere")
	  private Filiere filiere;

	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	/*
	 * @ManyToMany(mappedBy="matieres",cascade = { CascadeType.ALL }) private
	 * List<Filiere> filieres ;
	 */
	public Long getIdMatiere() {
		return idMatiere;
	}
	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/*
	 * public List<Filiere> getFilieres() { return filieres; } public void
	 * setFilieres(List<Filiere> filieres) { this.filieres = filieres; }
	 */
	public Matiere(Long idMatiere, String libelle, List<Filiere> filieres) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
		//this.filieres = filieres;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	} 
  
}
