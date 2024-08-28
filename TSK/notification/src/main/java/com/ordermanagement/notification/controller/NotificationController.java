package com.ordermanagement.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.notification.model.Notifications;
import com.ordermanagement.notification.service.NotificationService;

@RestController
@RequestMapping("/notifications")

public class NotificationController {
   

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public Notifications createNotification(@RequestBody Notifications notification) {
        return notificationService.createNotification(notification);
    }

    

    @GetMapping("/{id}")
    public Notifications getNotificationById(@PathVariable Long id) {
        return notificationService.getNotificationById(id);
    }

   
}



