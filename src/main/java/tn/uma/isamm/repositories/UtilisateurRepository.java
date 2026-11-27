package tn.uma.isamm.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.uma.isamm.entities.Role;
import tn.uma.isamm.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Optional<Utilisateur> findByEmail(String email);

	boolean existsByEmail(String email);

	Page<Utilisateur> findByRole(Role role, Pageable pageable);
}
