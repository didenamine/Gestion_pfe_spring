package tn.uma.isamm.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.uma.isamm.entities.Soutenance;

public interface SoutenanceRepository extends JpaRepository<Soutenance, Long> {
	List<Soutenance> findAllByOrderByDateSoutenanceAscHeureDebutAsc();

	List<Soutenance> findByDateSoutenanceBetweenOrderByDateSoutenanceAscHeureDebutAsc(LocalDate debut, LocalDate fin);

	@Query("select count(s) from Soutenance s where s.salle = :salle and s.dateSoutenance = :date "
			+ "and s.heureDebut < :fin and s.heureFin > :debut")
	long compterConflitsSalle(@Param("salle") String salle, @Param("date") LocalDate date,
			@Param("debut") LocalTime debut, @Param("fin") LocalTime fin);
}
