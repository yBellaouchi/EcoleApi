package ehei.EcoleApi.Dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ehei.EcoleApi.Entity.Filiere;

public interface FiliereRepository extends JpaRepository<Filiere,Long> {
	@Query("select f from Filiere f where f.id =:x ")
	public List<Filiere> chercherfiliere(
			@Param ("x")long id);
}
