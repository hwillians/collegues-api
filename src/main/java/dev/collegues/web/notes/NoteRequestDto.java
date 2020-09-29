package dev.collegues.web.notes;

import javax.validation.constraints.NotBlank;

public class NoteRequestDto {

	@NotBlank
	private String text;

	private String matriculeCollegue;

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
	 * @return the matriculeCollegue
	 */
	public String getMatriculeCollegue() {
		return matriculeCollegue;
	}

	/**
	 * @param matriculeCollegue the matriculeCollegue to set
	 */
	public void setMatriculeCollegue(String matriculeCollegue) {
		this.matriculeCollegue = matriculeCollegue;
	}

}
