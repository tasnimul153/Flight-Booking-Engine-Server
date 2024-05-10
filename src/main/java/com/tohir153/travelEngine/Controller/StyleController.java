package com.tohir153.travelEngine.Controller;

import com.tohir153.travelEngine.Services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StyleController {

    private final StyleService styleService;

    @Autowired
    public StyleController(StyleService styleService) {
        this.styleService = styleService;
    }

    @GetMapping("/ticketStyleDefault")
    public Map<String, String> getStyles() throws IOException {
        String css = styleService.getTicketStyleDefault();
        Map<String, String> response = new HashMap<>();
        response.put("css", css);
        return response;
    }

    @PutMapping("/updateTicketStyleDefault")
    public Map<String, String> updateStyles(@RequestBody Map<String, String> newStyles) throws IOException {
        styleService.updateTicketStyleDefault(newStyles.get("css"));
        return newStyles;
    }
}
