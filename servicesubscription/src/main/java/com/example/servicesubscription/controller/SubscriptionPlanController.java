package com.example.servicesubscription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicesubscription.model.SubscriptionPlan;
import com.example.servicesubscription.service.SubscriptionPlanService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionPlanController {

    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @GetMapping
    public List<SubscriptionPlan> getAllPlans() {
        return subscriptionPlanService.getAllPlans();
    }

    @GetMapping("/{id}")
    public SubscriptionPlan getPlanById(@PathVariable Long id) {
        return subscriptionPlanService.getPlanById(id);
    }

    @PostMapping
    public SubscriptionPlan createPlan(@RequestBody SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanService.createPlan(subscriptionPlan);
    }
    @PutMapping("/{id}")
    public SubscriptionPlan updatePlanById(@PathVariable Long id, @RequestBody SubscriptionPlan subscriptionPlan) {
        
        
        return subscriptionPlanService.updatePlanById(id,subscriptionPlan);
    }

    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlan(id);
    }

}
