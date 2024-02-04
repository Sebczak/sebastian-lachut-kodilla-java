package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {
    private Map<String, Boolean> airportAvailability;

    public FlightSearch() {
        airportAvailability = new HashMap<>();
        airportAvailability.put("Warsaw", true);
        airportAvailability.put("Oslo", false);
        airportAvailability.put("Nairobi", true);
        airportAvailability.put("Barcelona", false);
        airportAvailability.put("Cracow", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException{
        String departure = flight.getDepartureAirport();
        String arrival = flight.getArrivalAirport();

        if (airportAvailability.get(departure) && airportAvailability.get(arrival)) {
            System.out.println("Flight from: " + departure + " to: " + arrival + " is available");
        } else {
            throw new RouteNotFoundException("Flight from: " + departure + " to: " + arrival + " is not available");
        }
    }

}
