package tn.uma.isamm.entities;

public enum RoleJury {
	PRESIDENT("Président"),
	RAPPORTEUR("Rapporteur"),
	ENCADRANT("Encadrant"),
	MEMBRE("Membre");

	private final String libelle;

	RoleJury(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
