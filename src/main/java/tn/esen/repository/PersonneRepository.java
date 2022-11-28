package tn.esen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esen.model.Client;
import tn.esen.model.Personne;
import tn.esen.model.Proprietaire;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,	Long> {

}
