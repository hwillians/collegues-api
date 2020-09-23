package dev.collegues.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.collegues.entity.Collegue;
import dev.collegues.web.repository.CollegueRepository;

@Service
public class serviceCollegue {

	private CollegueRepository cR;

	public List<Collegue> findByName(Integer nom) {

		return cR.findByName(nom);

	}

}
