package dev.collegues.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.collegues.entity.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	List<Collegue> findByName(Integer nom);

}
