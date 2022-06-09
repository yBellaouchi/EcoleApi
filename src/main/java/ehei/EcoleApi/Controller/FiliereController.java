package ehei.EcoleApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ehei.EcoleApi.Dao.FiliereRepository;
import ehei.EcoleApi.Entity.Filiere;

@RestController
public class FiliereController {
	@Autowired
	private FiliereRepository iFiliere;

	@GetMapping("/filiere")
	public List<Filiere> listFilieres() {

		System.out.println("list categorie");
		List<Filiere> filieres = iFiliere.findAll();
		return filieres;

	}

	@PostMapping("/filiere")
	public Filiere ajouterFiliere(@RequestParam(value = "libelle") String libelle) {

		Filiere f = new Filiere(libelle);
		iFiliere.save(f);
		return f;
	}

	@GetMapping("/filiere/{id}")
	public Optional<Filiere> chercherFiliere(@PathVariable Long id) {

		Optional<Filiere> f = iFiliere.findById((long) id);
		return f;

	}

	@DeleteMapping("/filiere/{id}")
	public void deleteFilier(@PathVariable int id) {
		iFiliere.deleteById((long) id);
	}

	@PutMapping("/filiere/{id}")
	public Filiere updateFiliere(@PathVariable Long id, @RequestParam String libelle) {

		Filiere f = new Filiere();
		f.setIdFiliere(id);
		f.setLibelle(libelle);
		iFiliere.save(f);
		return f;
	}

}
