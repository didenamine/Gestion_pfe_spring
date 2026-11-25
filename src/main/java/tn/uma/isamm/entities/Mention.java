package tn.uma.isamm.entities;

public enum Mention {
	AJOURNE("Ajourné"),
	PASSABLE("Passable"),
	ASSEZ_BIEN("Assez bien"),
	BIEN("Bien"),
	TRES_BIEN("Très bien");

	private final String libelle;

	Mention(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public static Mention depuisNote(double note) {
		if (note < 10) {
			return AJOURNE;
		}
		if (note < 12) {
			return PASSABLE;
		}
		if (note < 14) {
			return ASSEZ_BIEN;
		}
		if (note < 16) {
			return BIEN;
		}
		return TRES_BIEN;
	}
}
