package tn.uma.isamm.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Enseignant extends Utilisateur {
	private int quotaMax;
}
