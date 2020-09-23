package dev.collegues.web.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.collegues.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findAllByNom(String nom);

	@Query("select c from Collegue c where c.matricule=?1")
	Optional<Collegue> findByMatricule(String matricule);

}
