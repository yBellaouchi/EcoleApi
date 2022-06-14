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
import ehei.EcoleApi.Dao.FiliereRepository;
import ehei.EcoleApi.Entity.Etudiant;
import ehei.EcoleApi.Entity.Filiere;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

	@Autowired
	private EtudiantRepository iEtudiant;

	@Autowired
	private FiliereRepository iFiliere;
	
	@GetMapping
	public List<Etudiant> listEtudiant() {

		List<Etudiant> etudiants = iEtudiant.findAll();
		return etudiants;

	}

	@PostMapping
	public Etudiant ajouterEtudiant(@RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "cin") String cin,
			@RequestParam(value = "age") int age, @RequestParam(value = "filiere") String filiere) {
		Filiere f = iFiliere.findByLibelle(filiere);
		Etudiant e = new Etudiant(nom, prenom, cin, age, f);
		iEtudiant.save(e);
		System.out.println("saved");
		return e;
	}
	
	@GetMapping("/{id}")
	public Etudiant chercherEtudiant(@PathVariable Long id) {

	   Etudiant e = iEtudiant.findOne((long) id);
	  return e;

	}
	@DeleteMapping("/{id}")
	public void deleteEtudiant(@PathVariable int id) {
		iEtudiant.deleteById((long) id);
	}

	@PutMapping("/{id}")
	public Etudiant updateEtudiant(@PathVariable Long id, @RequestParam(value = "nom") String nom,
			@RequestParam(value = "prenom") String prenom, @RequestParam(value = "cin") String cin,
			@RequestParam(value = "age") int age, @RequestParam(value = "filiere") String filiere) {
		Filiere f = iFiliere.findByLibelle(filiere);
		Etudiant e = iEtudiant.findOne((long) id);
		e.setNom(nom);
		e.setPrenom(prenom);
		e.setCin(cin);
		e.setAge(age);
		e.setFiliere(f);

		iEtudiant.save(e);
		return e;
	}
	
	
}
