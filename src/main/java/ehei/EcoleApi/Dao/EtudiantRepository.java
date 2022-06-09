package ehei.EcoleApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import ehei.EcoleApi.Entity.Etudiant;
import ehei.EcoleApi.Entity.Filiere;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
	@Query("select f from Etudiant f where f.id = ?1")
	Etudiant findOne(Long id);

}
