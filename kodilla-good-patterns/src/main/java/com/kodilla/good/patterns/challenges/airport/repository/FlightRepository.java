package com.kodilla.good.patterns.challenges.airport.repository;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;

import java.util.List;

public interface FlightRepository {

    List<Flight> initializeFlights();
}
