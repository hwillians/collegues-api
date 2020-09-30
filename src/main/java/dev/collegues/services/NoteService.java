package dev.collegues.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.collegues.entity.Note;
import dev.collegues.repository.CollegueRepository;
import dev.collegues.repository.NoteRepository;
import dev.collegues.web.notes.NoteReponseDto;

@Service
public class NoteService {

	private NoteRepository noteRep;
	private CollegueRepository collegueRepository;

	public NoteService(NoteRepository noteRep, CollegueRepository collegueRepository) {
		this.noteRep = noteRep;
		this.collegueRepository = collegueRepository;
	}

	public Note creerNote(String text, String matriculeCollegue) {

		Note note = new Note();

		note.setText(text);
		note.setDate(LocalDateTime.now());
		note.setCollegue(collegueRepository.findByMatricule(matriculeCollegue).orElseThrow(
				() -> new RuntimeException("erreur : cette matricule ne corresponde pas à aucune collegue")));

		noteRep.save(note);

		return note;
	}

	public List<NoteReponseDto> listerNotes(String matricule) {
		List<Note> listNotes = noteRep.findAllByMatricule(matricule);

		List<NoteReponseDto> listReponse = new ArrayList<>();

		for (Note note : listNotes) {
			listReponse.add(new NoteReponseDto(note));
		}

		return listReponse;
	}

	public List<NoteReponseDto> delateNote(Integer id) {

		Note note = noteRep.findById(id).orElseThrow(() -> new RuntimeException("erreur :suppresion de note"));

		noteRep.delete(note);

		return listerNotes(note.getCollegue().getMatricule());
	}

}
