package com.example.notification.controller;

import com.example.notification.model.Email;
import com.example.notification.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody Email email) {
        try {
            emailSenderService.sendEmail(email);
            return "Email sent successfully to " + email.getToEmail();
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}

