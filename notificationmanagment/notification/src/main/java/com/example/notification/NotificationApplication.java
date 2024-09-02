package com.example.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class NotificationApplication {
	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail(){
		senderService.sendEmail("vl946628@gmail.com", "This is subject", "This is Body of Email");
	}

}
