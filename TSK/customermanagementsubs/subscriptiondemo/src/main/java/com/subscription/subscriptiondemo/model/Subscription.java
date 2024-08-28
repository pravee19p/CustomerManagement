package com.subscription.subscriptiondemo.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subscription {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    private Long customerId;
    private Long servicePlanId;
    private LocalDate startDate;
    private LocalDate endDate;
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
    public Long getServicePlanId() {
        return servicePlanId;
    }
    public void setServicePlanId(Long servicePlanId) {
        this.servicePlanId = servicePlanId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public Subscription() {
    }
    public Subscription(Long id, Long customerId, Long servicePlanId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.customerId = customerId;
        this.servicePlanId = servicePlanId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        return "Subscription [id=" + id + ", customerId=" + customerId + ", servicePlanId=" + servicePlanId
                + ", startDate=" + startDate + ", endDate=" + endDate + "]";
    }
    

}
