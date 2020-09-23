package dev.collegues.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.collegues.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	@Query("select c from Collegue c where c.nom = ?1")
	List<Collegue> findByName(Integer nom);

}
