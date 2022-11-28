package tn.esen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esen.model.Endroit;
import tn.esen.model.reservation;
@Repository
public interface ReservationRepository extends JpaRepository<reservation, Long> {
	List<reservation> findByEndroit(Optional<Endroit> optional);

}
