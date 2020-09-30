package dev.collegues.web.notes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entity.Note;
import dev.collegues.services.NoteService;

@RestController
@CrossOrigin
@RequestMapping("notes")
public class NoteController {

	private NoteService noteServ;

	public NoteController(NoteService noteServ) {
		this.noteServ = noteServ;
	}

	@PostMapping
	public ResponseEntity<?> creerNote(@RequestBody @Valid NoteRequestDto noteReq, BindingResult resValid) {
		if (!resValid.hasErrors()) {

			Note note = noteServ.creerNote(noteReq.getText(), noteReq.getMatriculeCollegue());

			return ResponseEntity.ok(note);
		} else {
			return ResponseEntity.badRequest().body("tous les champs sont obligatoires !");
		}
	}

	@GetMapping("/{matricule}")
	public List<NoteReponseDto> listerNotes(@PathVariable String matricule) {
		return noteServ.listerNotes(matricule);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> effacerNotes(@PathVariable Integer id) {

		List<NoteReponseDto> isRemoved = noteServ.delateNote(id);

		if (isRemoved.isEmpty()) {
			return new ResponseEntity<>("Acune note ne corresponde pas à l'id : " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(isRemoved, HttpStatus.OK);

	}
}
