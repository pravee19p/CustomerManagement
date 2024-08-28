package com.ordermanagement.notification.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.notification.model.Notifications;

public interface NotificationRepository extends JpaRepository<Notifications, Long> {
}
