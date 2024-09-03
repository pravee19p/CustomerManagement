package com.example.notification.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.notification.model.Email;
import com.example.notification.repository.EmailRepository;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(Email email) {
        // Create a SimpleMailMessage object and set email properties
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("vijielakshmig@gmail.com");
        message.setTo(email.getToEmail());
        message.setText(email.getBody());
        message.setSubject(email.getSubject());

        // Send the email
        mailSender.send(message);

        // Save the email details to the database
        email.setSentAt(LocalDateTime.now()); // Set the timestamp to the current time
        emailRepository.save(email);

        System.out.println("Mail Sent.....");
    }
}
