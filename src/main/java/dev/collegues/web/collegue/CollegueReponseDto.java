package dev.collegues.web.collegue;

import dev.collegues.entity.Collegue;

public class CollegueReponseDto {

	private String matricule;

	private String photoUrl;

	public CollegueReponseDto(Collegue collegue) {
		this.matricule = collegue.getMatricule();
		this.photoUrl = collegue.getPhotoUrl();
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

}
