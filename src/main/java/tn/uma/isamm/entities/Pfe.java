package tn.uma.isamm.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pfe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titre;
	@Column(length = 2000)
	private String description;
	private String technologies;
	private String entreprise;
	private String encadrantProfessionnel;
	private String anneeUniversitaire;
	@Enumerated(EnumType.STRING)
	private Filiere filiere;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@Enumerated(EnumType.STRING)
	private StatutPfe statut;
	private LocalDate dateDepot;
	@ManyToOne
	private Enseignant encadrant;
	@OneToMany(mappedBy = "pfe")
	private List<Etudiant> etudiants = new ArrayList<>();
	@ManyToOne
	private Etudiant binomeInvite;
	@OneToOne(mappedBy = "pfe")
	private Soutenance soutenance;
	@Version
	private Long version;

	public boolean isBinome() {
		return niveau == Niveau.LICENCE;
	}

	public boolean isComplet() {
		return isBinome() ? etudiants.size() == 2 : etudiants.size() == 1;
	}

	public boolean contientEtudiant(Long etudiantId) {
		return etudiants.stream().anyMatch(e -> e.getId().equals(etudiantId));
	}

	public String getNomsEtudiants() {
		return etudiants.stream().map(Etudiant::getNomComplet).collect(Collectors.joining(" & "));
	}
}
