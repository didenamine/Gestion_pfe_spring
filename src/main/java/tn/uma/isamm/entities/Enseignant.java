package tn.uma.isamm.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Enseignant extends Utilisateur {
	private int quotaMax;
	@OneToMany(mappedBy = "encadrant")
	private List<Pfe> pfesEncadres = new ArrayList<>();
}
