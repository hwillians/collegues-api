package dev.collegues.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.collegues.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {

	@Query("select n from Note n join fetch n.collegue c where c.matricule =?1")
	List<Note> findAllByMatricule(String matricule);

}
