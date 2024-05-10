package com.tohir153.travelEngine.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tohir153.travelEngine.Services.EmailServices;

@RestController
public class EmailController {

    @Autowired
    private EmailServices emailServices;

    @PostMapping("/send-email")
    public ResponseEntity<MessageResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailServices.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok(new MessageResponse("Email sent successfully"));
    }
}

class EmailRequest {
    private String to;
    private String subject;
    private String body;

    // Standard getters and setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    // Getter and setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
