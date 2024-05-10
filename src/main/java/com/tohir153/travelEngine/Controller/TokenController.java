package com.tohir153.travelEngine.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;


@Controller
@RequestMapping("/api")
public class TokenController {
    // Inject values from the application configuration using @Value annotation
    @Value("${amadeus.api.key}")
    private String API_KEY;
    @Value("${amadeus.api.secret}")
    private String API_SECRET;
    @Value("${amadeus.api.url}")
    private String API_URL;

    // Define the endpoint for token generation and specify it to handle POST requests
    @PostMapping("/token")
    @ResponseBody
    public ResponseEntity<String> getToken() {
        try {
            // Prepare the data to be sent in the request body
            MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
            data.add("grant_type", "client_credentials");
            data.add("client_id", API_KEY);
            data.add("client_secret", API_SECRET);

            // Set the headers for the request, specifying the content type as application/x-www-form-urlencoded
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(data, headers);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<AmadeusTokenResponse> response = restTemplate.exchange(API_URL, HttpMethod.POST, requestEntity, AmadeusTokenResponse.class);

            // Save token and expiration time to cache
            return new ResponseEntity<>(Objects.requireNonNull(response.getBody()).getAccess_token(), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error generating token", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static class AmadeusTokenResponse {
        private String access_token;
        private String token_type;
        private String expires_in;

        public String getAccess_token() {
            return access_token;
        }
    }
}
