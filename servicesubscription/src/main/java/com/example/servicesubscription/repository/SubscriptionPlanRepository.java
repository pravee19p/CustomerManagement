package com.example.servicesubscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicesubscription.model.SubscriptionPlan;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long>  {

}
