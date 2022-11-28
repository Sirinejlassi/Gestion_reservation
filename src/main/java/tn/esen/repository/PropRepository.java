package tn.esen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esen.model.Endroit;
import tn.esen.model.Proprietaire;

@Repository
public interface PropRepository extends JpaRepository<Proprietaire, Long> {
	Proprietaire findByEndroit(Optional<Proprietaire> optional);

}
