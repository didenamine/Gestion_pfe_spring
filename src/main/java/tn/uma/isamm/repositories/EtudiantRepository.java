package tn.uma.isamm.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	Optional<Etudiant> findByEmail(String email);

	Optional<Etudiant> findByMatricule(String matricule);

	boolean existsByMatricule(String matricule);
}
