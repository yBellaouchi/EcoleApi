package ehei.EcoleApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ehei.EcoleApi.Dao.EtudiantRepository;
import ehei.EcoleApi.Dao.MatiereRepository;
import ehei.EcoleApi.Dao.ProfesseurRepository;
import ehei.EcoleApi.Entity.Etudiant;
import ehei.EcoleApi.Entity.Filiere;
import ehei.EcoleApi.Entity.Matiere;
import ehei.EcoleApi.Entity.Professeur;

@RestController
@RequestMapping("/professeur")
public class ProfesseurController {
	@Autowired
	private ProfesseurRepository iProfesseur;
	@Autowired
	private MatiereRepository iMatiere;
	@GetMapping
	public List<Professeur> listPrpfesseur() {

		List<Professeur> professeurs = iProfesseur.findAll();
		return professeurs;

	}
	
	@PostMapping
	public Professeur ajouterProfesseur(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "cin") String cin,
			 @RequestParam(value = "matiereLibelle") String matiereLibelle) {
		Matiere m = iMatiere.findByLibelle(matiereLibelle);
		System.out.println(m.getLibelle());
		Professeur p = new Professeur(nom, prenom, cin,m);
		System.out.println(p.getNom());
		iProfesseur.save(p);
		System.out.println("saved");
		return p;
	}
	@GetMapping("/{id}")
	public Professeur chercherProfesseur(@PathVariable Long id) {

	   Professeur p = iProfesseur.findOne((long) id);
	  return p;

	}
	@PutMapping("/{id}")
	public Professeur updateProfesseur(@PathVariable Long id, @RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "cin") String cin,
			 @RequestParam(value = "matiereLibelle") String matiereLibelle) {
		Matiere m = iMatiere.findByLibelle(matiereLibelle);
		System.out.println(m.getLibelle());
		Professeur e = iProfesseur.findOne((long) id);
		System.out.println(e.getNom());
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setCin(cin);
		e.setMatiere(m);

		iProfesseur.save(e);
		return e;
	}
	
	@DeleteMapping("/{id}")
	public void deleteProfesseur(@PathVariable Long id) {
		iProfesseur.deleteById((long) id);
	}
}
