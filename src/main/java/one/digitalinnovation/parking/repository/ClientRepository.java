package one.digitalinnovation.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.parking.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
