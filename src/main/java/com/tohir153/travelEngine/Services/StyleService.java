package com.tohir153.travelEngine.Services;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class StyleService {
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public StyleService(ResourceLoader resourceLoader, ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public String getTicketStyleDefault() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:ticketStyleDefault.json");
        JsonNode jsonNode = objectMapper.readTree(resource.getInputStream());
        return jsonNode.get("css").asText();
    }

    public void updateTicketStyleDefault(String newStyles) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:ticketStyleDefault.json");
        ObjectNode originalJson = (ObjectNode) objectMapper.readTree(resource.getInputStream());
        originalJson.put("css", newStyles);
        Files.write(Paths.get(resource.getFile().getPath()), objectMapper.writeValueAsBytes(originalJson));
    }
}

