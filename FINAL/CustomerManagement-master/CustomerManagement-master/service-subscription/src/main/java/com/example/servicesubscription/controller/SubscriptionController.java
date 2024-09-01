package com.example.servicesubscription.controller;

import com.example.servicesubscription.model.Subscription;
import com.example.servicesubscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
        return subscriptionService.getSubscriptionById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.saveSubscription(subscription);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id, @RequestBody Subscription subscription) {
        if (!subscriptionService.getSubscriptionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subscription.setSubscriptionId(id);
        return ResponseEntity.ok(subscriptionService.saveSubscription(subscription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        if (!subscriptionService.getSubscriptionById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.noContent().build();
    }
}