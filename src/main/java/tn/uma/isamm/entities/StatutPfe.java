package tn.uma.isamm.entities;

public enum StatutPfe {
	DEPOSE("Déposé"),
	VALIDE("Validé"),
	ENCADRE("Encadré"),
	SOUTENANCE_PLANIFIEE("Soutenance planifiée"),
	SOUTENU("Soutenu");

	private final String libelle;

	StatutPfe(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
}
