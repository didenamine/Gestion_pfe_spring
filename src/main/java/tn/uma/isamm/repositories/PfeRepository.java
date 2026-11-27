package tn.uma.isamm.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.uma.isamm.entities.Enseignant;
import tn.uma.isamm.entities.Etudiant;
import tn.uma.isamm.entities.Filiere;
import tn.uma.isamm.entities.Pfe;
import tn.uma.isamm.entities.StatutPfe;

public interface PfeRepository extends JpaRepository<Pfe, Long> {
	long countByStatut(StatutPfe statut);

	long countByEncadrantIsNull();

	long countByEncadrantAndAnneeUniversitaire(Enseignant encadrant, String anneeUniversitaire);

	List<Pfe> findByStatutOrderByDateDepotAsc(StatutPfe statut);

	List<Pfe> findByEncadrantOrderByStatutAsc(Enseignant encadrant);

	List<Pfe> findByBinomeInvite(Etudiant etudiant);

	List<Pfe> findAllByOrderByDateDepotDesc();

	@Query("select p from Pfe p left join p.encadrant e "
			+ "where (:statut is null or p.statut = :statut) "
			+ "and (:filiere is null or p.filiere = :filiere) "
			+ "and (:entreprise is null or lower(p.entreprise) like lower(concat('%', :entreprise, '%'))) "
			+ "and (:encadrantId is null or e.id = :encadrantId) "
			+ "and (:annee is null or p.anneeUniversitaire = :annee)")
	Page<Pfe> rechercher(@Param("statut") StatutPfe statut, @Param("filiere") Filiere filiere,
			@Param("entreprise") String entreprise, @Param("encadrantId") Long encadrantId,
			@Param("annee") String annee, Pageable pageable);

	@Query("select distinct p.anneeUniversitaire from Pfe p order by p.anneeUniversitaire desc")
	List<String> listerAnnees();
}
