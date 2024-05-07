package com.example.queries1.repository;

import com.example.queries1.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Modifying
    @Query(value = "INSERT INTO Flight (description, from_airport, to_airport, status) VALUES (:description, :fromAirport, :toAirport, :status)", nativeQuery = true)
    void saveFlight(@Param("description") String description, @Param("fromAirport") String fromAirport, @Param("toAirport") String toAirport, @Param("status") Flight.Status status);

}
