package tn.uma.isamm.entities;

public enum Role {
	ETUDIANT("Étudiant"),
	ENSEIGNANT("Enseignant"),
	ADMINISTRATEUR("Administrateur");

	private final String libelle;

	Role(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
