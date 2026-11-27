package tn.uma.isamm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.entities.Enseignant;

public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
	Optional<Enseignant> findByEmail(String email);

	List<Enseignant> findAllByOrderByNomAsc();
}
