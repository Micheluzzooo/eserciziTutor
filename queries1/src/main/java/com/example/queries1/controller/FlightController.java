package com.example.queries1.controller;

import com.example.queries1.entity.Flight;
import com.example.queries1.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/getAll")
    public List<Flight> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights;
    }

    @GetMapping("/generateFlights")
    public void generateFlights() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription(RandomStringUtils.randomAlphabetic(10));
            flight.setFromAirport(RandomStringUtils.randomAlphabetic(3));
            flight.setToAirport(RandomStringUtils.randomAlphabetic(3));
            flight.setStatus(Flight.Status.ON_TIME);
            flightRepository.save(flight);
        }
    }
}
