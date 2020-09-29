package dev.collegues.web.notes;

import java.time.LocalDateTime;

import dev.collegues.entity.Note;

public class NoteReponseDto {

	private Integer id;

	private String text;

	private LocalDateTime date;

	public NoteReponseDto(Note note) {
		id = note.getId();
		text = note.getText();
		date = note.getDate();

	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the date
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
