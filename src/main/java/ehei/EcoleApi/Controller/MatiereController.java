package ehei.EcoleApi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ehei.EcoleApi.Dao.FiliereRepository;
import ehei.EcoleApi.Dao.MatiereRepository;
import ehei.EcoleApi.Entity.Filiere;
import ehei.EcoleApi.Entity.Matiere;

@RestController
@RequestMapping("/matiere")
public class MatiereController {
	@Autowired
	private MatiereRepository iMatiere;
	
	@Autowired
	private FiliereRepository iFiliere;
	
	
	@GetMapping()
	public List<Matiere> listFilieres() {

		System.out.println("list categorie");
		List<Matiere> matieres = iMatiere.findAll();
		return matieres;
	}
	
	@PostMapping()
	public Matiere ajouterMatieres(@RequestParam(value = "libelle") String libelle,@RequestParam(value = "libelleFiliere") String libelleFiliere) {

		 Filiere filiere=iFiliere.findByLibelle(libelleFiliere);
		Matiere matiere=new Matiere(libelle,filiere);
		iMatiere.save(matiere);
		return matiere;
	}
	
	@GetMapping("/{id}")
	public Optional<Matiere> chercherMatiere(@PathVariable Long id) {

		Optional<Matiere> m = iMatiere.findById((long) id);
		return m;

	}
	
	@PutMapping("/{id}")
	public Matiere updateMatiere(@PathVariable Long id, @RequestParam String libelle, @RequestParam String libelleFiliere) {

		Filiere filiere=iFiliere.findByLibelle(libelleFiliere);
		System.out.println(filiere.getLibelle());
		Matiere m = new Matiere();
		m.setIdMatiere(id);
		m.setLibelle(libelle);
		m.setFiliere(filiere);
		iMatiere.save(m);
		return m;
	}
	@DeleteMapping("/{id}")
	public void deleteMatiere(@PathVariable int id) {
		iMatiere.deleteById((long) id);
	}


		
}
