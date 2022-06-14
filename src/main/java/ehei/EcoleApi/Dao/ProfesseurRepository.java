package ehei.EcoleApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ehei.EcoleApi.Entity.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long>{

	@Query("select p from Professeur p where p.id = ?1")
	Professeur findOne(Long id);

}
