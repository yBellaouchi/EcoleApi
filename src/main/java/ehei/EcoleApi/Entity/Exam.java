package ehei.EcoleApi.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Exam implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date date;
	

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="id",insertable = false, updatable = false)
	  private Professeur professer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="idMatiere",insertable = false, updatable = false)
	  private Matiere matiere;
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Exam(Date date, Matiere matiere, Professeur professer) {
		super();
		this.date = date;
		this.matiere = matiere;
		this.professer = professer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Professeur getProfesser() {
		return professer;
	}

	public void setProfesser(Professeur professer) {
		this.professer = professer;
	}


}
