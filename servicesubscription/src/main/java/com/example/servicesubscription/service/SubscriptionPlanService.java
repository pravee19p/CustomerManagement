package com.example.servicesubscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicesubscription.model.SubscriptionPlan;
import com.example.servicesubscription.repository.SubscriptionPlanRepository;
@Service
public class SubscriptionPlanService {
      @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanRepository.findAll();
    }

    public SubscriptionPlan getPlanById(Long id) {
        return subscriptionPlanRepository.findById(id).orElse(null);
    }

    public SubscriptionPlan createPlan(SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepository.save(subscriptionPlan);
    }public SubscriptionPlan updatePlanById(Long id,SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepository.save(subscriptionPlan);
    }
    

    public void deletePlan(Long id) {
        subscriptionPlanRepository.deleteById(id);
    }
}


