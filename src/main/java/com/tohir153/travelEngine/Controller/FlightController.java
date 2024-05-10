package com.tohir153.travelEngine.Controller;


import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightOfferSearch;
import com.tohir153.travelEngine.Services.AmadeusConnect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
    @GetMapping("/flights")
    public FlightOfferSearch[] flights(@RequestParam(required=true) String origin,
                                       @RequestParam(required=true) String destination,
                                       @RequestParam(required=true) String departDate,
                                       @RequestParam(required=true) String adults,
                                       @RequestParam(required = false) String returnDate,
                                       @RequestParam(required = false) String currencyCode,
                                       @RequestParam(required = false) String travelClass)
            throws ResponseException {
        return AmadeusConnect.INSTANCE.flights(origin, destination, departDate, adults, returnDate, currencyCode, travelClass);
    }
}
