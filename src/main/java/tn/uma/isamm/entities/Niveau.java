package tn.uma.isamm.entities;

public enum Niveau {
	INGENIEUR("Classe terminale ingénieur"),
	LICENCE("Classe terminale licence");

	private final String libelle;

	Niveau(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
