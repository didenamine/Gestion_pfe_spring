package tn.uma.isamm.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.uma.isamm.entities.Enseignant;
import tn.uma.isamm.entities.MembreJury;

public interface MembreJuryRepository extends JpaRepository<MembreJury, Long> {
	List<MembreJury> findByEnseignantOrderBySoutenanceDateSoutenanceAsc(Enseignant enseignant);

	@Query("select count(m) from MembreJury m where m.enseignant.id = :enseignantId "
			+ "and m.soutenance.dateSoutenance = :date "
			+ "and m.soutenance.heureDebut < :fin and m.soutenance.heureFin > :debut")
	long compterConflitsEnseignant(@Param("enseignantId") Long enseignantId, @Param("date") LocalDate date,
			@Param("debut") LocalTime debut, @Param("fin") LocalTime fin);
}
