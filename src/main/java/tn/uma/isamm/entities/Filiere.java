package tn.uma.isamm.entities;

public enum Filiere {
	GENIE_LOGICIEL("Génie Logiciel"),
	INFORMATIQUE("Informatique"),
	MULTIMEDIA("Multimédia"),
	RESEAUX("Réseaux et Télécommunications");

	private final String libelle;

	Filiere(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
