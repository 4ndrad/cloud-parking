package one.digitalinnovation.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinnovation.parking.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{

}
