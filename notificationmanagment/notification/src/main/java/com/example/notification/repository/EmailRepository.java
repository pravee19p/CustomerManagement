package com.example.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notification.model.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
