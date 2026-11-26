package tn.uma.isamm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant extends Utilisateur {
	@Column(unique = true)
	private String matricule;
	@Enumerated(EnumType.STRING)
	private Filiere filiere;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	@ManyToOne
	private Pfe pfe;
}
