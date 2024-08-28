package com.subscription.subscriptiondemo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subscription.subscriptiondemo.model.Subscription;
import com.subscription.subscriptiondemo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
    

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription getSubscription(Long id) {
        return subscriptionRepository.findById(id).orElse(null);
    }

    public Subscription updateSubscription(Long id, Subscription subscriptionDetails) {
        Subscription subscription = subscriptionRepository.findById(id).orElse(null);
        if (subscription != null) {
            subscription.setStartDate(subscriptionDetails.getStartDate());
            subscription.setEndDate(subscriptionDetails.getEndDate());
            subscription.setServicePlanId(subscriptionDetails.getServicePlanId());
            return subscriptionRepository.save(subscription);
        }
        return null;
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }

   

}
