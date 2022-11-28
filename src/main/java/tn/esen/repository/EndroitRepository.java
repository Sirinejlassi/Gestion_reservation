package tn.esen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esen.model.Endroit;

@Repository
public interface EndroitRepository extends JpaRepository<Endroit, Long> {

}
