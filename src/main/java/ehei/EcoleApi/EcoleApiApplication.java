package ehei.EcoleApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ehei.EcoleApi.Dao.EtudiantRepository;
import ehei.EcoleApi.Dao.FiliereRepository;
import ehei.EcoleApi.Entity.Etudiant;
import ehei.EcoleApi.Entity.Filiere;

@SpringBootApplication
public class EcoleApiApplication implements CommandLineRunner {
@Autowired
private FiliereRepository iFiliere;


@Autowired
private EtudiantRepository iEtudiant;


	public static void main(String[] args) {
		SpringApplication.run(EcoleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * Filiere f=new Filiere("genie info"); iFiliere.save(f); System.out.println(f);
		 */
		 /** 
		 * 
		 * System.out.println("list filieres"); List<Filiere>filieres=new ArrayList();
		 * filieres=iFiliere.findAll(); for (Filiere filiere : filieres) {
		 * System.out.println(filiere.getLibelle()); }
		 * 
		 * 
		 * System.out.println("chercher filieres");
		 * List<Filiere>filieress=(List<Filiere>) iFiliere.chercherfiliere((long) 1);
		 * Optional<Filiere> ff=iFiliere.findById((long) 3);
		 * System.out.println(ff.get().getLibelle());
		 */	
		System.out.println("hi");
		
	
		Etudiant e = iEtudiant.findOne((long) 3);
		System.out.println(e.getNom());
		
		
	}
	
	

}
