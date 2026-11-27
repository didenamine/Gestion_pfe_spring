package tn.uma.isamm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.uma.isamm.entities.Resultat;

public interface ResultatRepository extends JpaRepository<Resultat, Long> {
	List<Resultat> findByValideTrueOrderByDateValidationDesc();

	long countByValideTrue();

	@Query("select r.mention, count(r) from Resultat r where r.valide = true group by r.mention")
	List<Object[]> compterParMention();

	@Query("select avg(r.note) from Resultat r where r.valide = true")
	Double calculerMoyenne();
}
