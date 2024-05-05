package com.example.queries2.repository;

import com.example.queries2.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query("SELECT f FROM Flight f WHERE f.fromAirport = :fromAirport")
    List<Flight> findByFromAirport(@Param("fromAirport") String fromAirport);

    @Query("SELECT f FROM Flight f WHERE f.status = 'ONTIME'")
    List<Flight> findByStatusOntime();

    @Query("SELECT f FROM Flight f WHERE f.status IN (:status)")
    List<Flight> findByStatusIn(@Param("status") List<String> status);
}
