package com.example.servicesubscription.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;

    private String plan;
    private Integer timePeriod;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(String plan) {
        this.plan = plan;
        setTimePeriodFromPlan(plan);
    }

    private void setTimePeriodFromPlan(String plan) {
        SubscriptionPlanType type = SubscriptionPlanType.fromString(plan);
        this.timePeriod = type.getTimePeriod();
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
        setTimePeriodFromPlan(plan);
    }

    public Integer getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Integer timePeriod) {
        this.timePeriod = timePeriod;
    }
}