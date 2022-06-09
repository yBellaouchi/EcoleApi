package ehei.EcoleApi.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Filiere implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFiliere;
	private String libelle;
	@ManyToOne
	@JoinColumn(name="idMatiere")
	  private Matiere matiere;
	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	/*
	 * @ManyToMany(cascade = { CascadeType.ALL })
	 * 
	 * @JoinTable( name="Fil_Mat", joinColumns=@JoinColumn(name="idFiliere",
	 * referencedColumnName="idFiliere"),
	 * inverseJoinColumns=@JoinColumn(name="idMatiere",referencedColumnName=
	 * "idMatiere")) private List<Matiere> matieres ;
	 */
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List<Matiere> getMatieres() { return matieres; }
	 * 
	 * public void setMatieres(List<Matiere> matieres) { this.matieres = matieres; }
	 */

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getLibelle() {
		return libelle;
	}

	public Filiere(Long idFiliere, String libelle) {
		super();
		this.idFiliere = idFiliere;
		this.libelle = libelle;
	}

	public Filiere(String libelle) {
		this.libelle = libelle;
		}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
		 
}
