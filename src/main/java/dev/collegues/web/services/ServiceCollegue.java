package dev.collegues.web.services;

import java.util.List;

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

		return collegueRepository.findByName(nom);

	}

}
