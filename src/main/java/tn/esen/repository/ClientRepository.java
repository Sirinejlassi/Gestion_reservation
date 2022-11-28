package tn.esen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esen.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
