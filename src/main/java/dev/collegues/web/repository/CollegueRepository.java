package dev.collegues.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dev.collegues.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	@Query("select c.matricule from Collegue c where c.nom=?1")
	List<String> findAllByNom(String nom);

	@Query("select c from Collegue c where c.matricule=?1")
	Optional<Collegue> findByMatricule(String matricule);

	@Modifying
	@Query("update Collegue c set c.email = ?2, c.photoUrl=?3 where c.matricule=?1")
	void update(String matricule, String email, String urlPhoto);

}
