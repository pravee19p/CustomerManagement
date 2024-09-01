package com.example.notificationservice.listener;

import com.example.notificationservice.entity.Notification;
import com.example.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = "notification-queue")
    public void receiveMessage(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notificationService.createNotification(notification);
    }
}
