package com.ordermanagement.notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long customerId;
    private String message;
    private String status; // e.g., "SENT", "PENDING", "FAILED"
    private String type; // e.g., "EMAIL", "SMS"
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Notifications() {
    }
    public Notifications(Long id, Long customerId, String message, String status, String type) {
        this.id = id;
        this.customerId = customerId;
        this.message = message;
        this.status = status;
        this.type = type;
    }
    @Override
    public String toString() {
        return "Notifications [id=" + id + ", customerId=" + customerId + ", message=" + message + ", status=" + status
                + ", type=" + type + "]";
    }
    
    
}



