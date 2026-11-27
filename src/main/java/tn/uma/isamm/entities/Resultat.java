package tn.uma.isamm.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Resultat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Soutenance soutenance;
	@DecimalMin(value = "0.0", message = "La note doit être comprise entre 0 et 20")
	@DecimalMax(value = "20.0", message = "La note doit être comprise entre 0 et 20")
	private double note;
	@Enumerated(EnumType.STRING)
	private Mention mention;
	@Column(length = 1000)
	private String remarques;
	private boolean valide;
	private LocalDate dateValidation;
}
