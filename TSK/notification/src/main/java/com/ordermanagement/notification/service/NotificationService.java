package com.ordermanagement.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.notification.model.Notifications;
import com.ordermanagement.notification.repository.NotificationRepository;

@Service
public class NotificationService {  
        @Autowired
        private NotificationRepository notificationRepository;
    
        public Notifications createNotification(Notifications notification) {
            return notificationRepository.save(notification);
        }
    
    
        public Notifications getNotificationById(Long id) {
            return notificationRepository.findById(id).orElse(null);
        }
    
       
    }
    

