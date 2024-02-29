package com.kodilla.good.patterns.challenges.airport.processor;

import com.kodilla.good.patterns.challenges.airport.flight.Flight;
import com.kodilla.good.patterns.challenges.airport.information.FlightInformationService;
import com.kodilla.good.patterns.challenges.airport.repository.FlightRepository;
import com.kodilla.good.patterns.challenges.airport.request.FlightDto;
import com.kodilla.good.patterns.challenges.airport.request.FlightRequest;
import com.kodilla.good.patterns.challenges.airport.service.FlightService;

import java.util.List;

public class FlightProcessor {

    private FlightInformationService flightInformationService;
    private FlightService flightService;
    private FlightRepository flightRepository;

    public FlightProcessor(FlightInformationService flightInformationService, FlightService flightService, FlightRepository flightRepository) {
        this.flightInformationService = flightInformationService;
        this.flightService = flightService;
        this.flightRepository = flightRepository;
    }

    public FlightDto checkFlight(FlightRequest flightRequest) {

        List<Flight> allFlights = flightRepository.initializeFlights();
        System.out.println(allFlights);
        List<Flight> directFlights = flightService.findFlightsFromTheCity(allFlights, flightRequest.getDepartureCity());
        System.out.println(directFlights);
        List<Flight> returnFlights = flightService.findFlightsToCity(allFlights, flightRequest.getDestinationCity());
        System.out.println(returnFlights);
        List<Flight> connectingFlights = flightService.findDirectAndThroughCityFlights(allFlights, flightRequest.getDepartureCity(), flightRequest.getDestinationCity());
        System.out.println(connectingFlights);
        flightInformationService.inform();

        return new FlightDto(directFlights,returnFlights,connectingFlights);
    }
}
