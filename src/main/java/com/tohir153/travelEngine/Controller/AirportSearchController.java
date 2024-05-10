package com.tohir153.travelEngine.Controller;

import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.Location;
import com.tohir153.travelEngine.Services.AmadeusConnect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportSearchController {
    @GetMapping("/locations")
    public Location[] locations(@RequestParam(required=true) String keyword) throws ResponseException {
        return AmadeusConnect.INSTANCE.location(keyword);
    }
}
