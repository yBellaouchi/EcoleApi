package ehei.EcoleApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ehei.EcoleApi.Entity.Filiere;
import ehei.EcoleApi.Entity.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere,Long>{
	
	
	@Query("select f from Matiere f where f.libelle = ?1")
	Matiere findByLibelle(String libelle);

}
