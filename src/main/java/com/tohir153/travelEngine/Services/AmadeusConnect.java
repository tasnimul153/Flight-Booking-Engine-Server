package com.tohir153.travelEngine.Services;
import com.amadeus.Amadeus;
import com.amadeus.Params;
import com.amadeus.referenceData.Locations;
import com.amadeus.resources.FlightOfferSearch;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public enum AmadeusConnect {
    INSTANCE;
    private final Amadeus amadeus;
    /*@Value("${amadeus.api.key}")
    private String API_KEY;
    @Value("${amadeus.api.secret}")
    private String API_SECRET;
    @Value("${amadeus.api.url}")
    private String API_URL;*/
    private AmadeusConnect() {
        this.amadeus = Amadeus
                .builder("hzdpXSNcnNoEqfE7FbDzAp5vMtmXQBDc", "5YAkYcudcGNU89S0")
                .build();
    }
   /*AmadeusConnect() {
       this.amadeus = Amadeus
               .builder(API_KEY, API_SECRET)
               .build();
   }*/
    public Location[] location(String keyword) throws ResponseException {
        return amadeus.referenceData.locations.get(Params
                .with("keyword", keyword)
                .and("subType", Locations.AIRPORT));
    }
    public FlightOfferSearch[] flights(String origin, String destination, String departDate, String adults, String returnDate, String currencyCode, String travelClass) throws ResponseException {
        return amadeus.shopping.flightOffersSearch.get(
                Params.with("originLocationCode", origin)
                        .and("destinationLocationCode", destination)
                        .and("departureDate", departDate)
                        .and("adults", adults)
                        .and("max", 50)
                        .and("currencyCode", currencyCode)
                        .and("nonStop", false)
                        .and("travelClass", travelClass));
    }
}