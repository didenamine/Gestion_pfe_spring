package tn.uma.isamm.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Soutenance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Pfe pfe;
	private LocalDate dateSoutenance;
	private LocalTime heureDebut;
	private LocalTime heureFin;
	private String salle;
	@OneToMany(mappedBy = "soutenance", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<MembreJury> jury = new ArrayList<>();
	@OneToOne(mappedBy = "soutenance", cascade = CascadeType.ALL, orphanRemoval = true)
	private Resultat resultat;

	public void ajouterMembre(Enseignant enseignant, RoleJury role) {
		MembreJury membre = new MembreJury();
		membre.setSoutenance(this);
		membre.setEnseignant(enseignant);
		membre.setRole(role);
		jury.add(membre);
	}

	public boolean contientMembre(Long enseignantId) {
		return jury.stream().anyMatch(m -> m.getEnseignant().getId().equals(enseignantId));
	}

	public RoleJury roleDe(Long enseignantId) {
		return jury.stream()
				.filter(m -> m.getEnseignant().getId().equals(enseignantId))
				.map(MembreJury::getRole)
				.findFirst()
				.orElse(null);
	}

	public Enseignant membreAvecRole(RoleJury role) {
		return jury.stream()
				.filter(m -> m.getRole() == role)
				.map(MembreJury::getEnseignant)
				.findFirst()
				.orElse(null);
	}
}
