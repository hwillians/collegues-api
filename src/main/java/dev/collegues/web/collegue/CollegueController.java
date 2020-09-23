package dev.collegues.web.collegue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entity.Collegue;
import dev.collegues.web.services.ServiceCollegue;

@RestController
@RequestMapping("collegues")
public class CollegueController {

	private ServiceCollegue serviceCollegue;

	public CollegueController(ServiceCollegue serviceCollegue) {
		this.serviceCollegue = serviceCollegue;
	}

	@GetMapping
	public List<String> ListHotels(@RequestParam String nom) {

		List<String> listMatricules = new ArrayList<>();
		List<Collegue> listCollegue = serviceCollegue.findByName(nom);
		for (Collegue c : listCollegue) {
			listMatricules.add(c.getMatricule());
		}
		return listMatricules;
	}

	@GetMapping("/{matricule}")
	public ResponseEntity<?> infoCollegue(@PathVariable String matricule) {

		Optional<Collegue> opCollegue = serviceCollegue.findByMatricule(matricule);

		if (opCollegue.isPresent()) {
			return ResponseEntity.ok(new reponseDtoMatricule(opCollegue.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> newCollegue(@RequestBody @Valid ColleguerequestDto colreq, BindingResult resValid) {

		if (!resValid.hasErrors()) {
			Collegue collegue = serviceCollegue.creerCollegue(colreq.getNom(), colreq.getPrenoms(),
					colreq.getDateDeNaissance(), colreq.getPhotoUrl());

			return ResponseEntity.ok(collegue);
		} else {
			return ResponseEntity.badRequest().body("tous les champs sont obligatoires !");
		}

	}

}
