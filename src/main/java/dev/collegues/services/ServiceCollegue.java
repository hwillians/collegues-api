package dev.collegues.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.collegues.entity.Collegue;
import dev.collegues.repository.CollegueRepository;
import dev.collegues.web.collegue.CollegueReponseDto;

@Service
public class ServiceCollegue {

	private CollegueRepository collegueRepository;

	public ServiceCollegue(CollegueRepository collegueRepository) {
		this.collegueRepository = collegueRepository;
	}

	public List<String> findByName(String nom) {
		return collegueRepository.findAllByNom(nom);
	}

	public Optional<Collegue> findByMatricule(String matricule) {
		return collegueRepository.findByMatricule(matricule);
	}

	@Transactional
	public Collegue creerCollegue(String nom, String prenoms, LocalDate dateDeNaissance, String photoUrl) {
		Collegue collegue = new Collegue(nom, prenoms, dateDeNaissance, photoUrl);

		return collegueRepository.save(collegue);
	}

	@Transactional
	public Collegue updateCollegue(String matricule, String email, String urlPhoto) {
		collegueRepository.update(matricule, email, urlPhoto);
		return collegueRepository.findByMatricule(matricule)
				.orElseThrow(() -> new RuntimeException("erreur : actualisation Collegue"));
	}

	public List<CollegueReponseDto> findAll() {
		List<CollegueReponseDto> listCollegues = new ArrayList<CollegueReponseDto>();
		for (Collegue c : collegueRepository.findAll()) {
			listCollegues.add(new CollegueReponseDto(c));
		}

		return listCollegues;
	}

}
