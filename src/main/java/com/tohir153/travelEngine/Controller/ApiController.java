package com.tohir153.travelEngine.Controller;

import com.tohir153.travelEngine.Services.AmadeusConnect;
import com.amadeus.resources.Location;
import com.amadeus.exceptions.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ApiController {

    private AmadeusConnect amadeusConnect;

    @GetMapping("/locations")
    public Location[] locations(@RequestParam(required=true) String keyword) throws ResponseException {
        return amadeusConnect.location(keyword);
    }
}
