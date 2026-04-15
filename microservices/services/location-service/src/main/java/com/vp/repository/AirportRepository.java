package com.vp.repository;

import com.vp.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByIataCode(String iataCode);

    List<Airport> findByCityId(Long cityId);

}
