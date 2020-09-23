package dev.collegues.web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.collegues.entity.Collegue;
import dev.collegues.web.repository.CollegueRepository;

@Service
public class ServiceCollegue {

	private CollegueRepository collegueRepository;

	public ServiceCollegue(CollegueRepository collegueRepository) {
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> findByName(Integer nom) {

		return collegueRepository.findAllByName(nom);

	}

	public Optional<Collegue> findByMatricul(String matricule) {

		return collegueRepository.findByMatricule(matricule);
	}

}
