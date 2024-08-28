package com.subscription.subscriptiondemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.subscription.subscriptiondemo.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long>{

 

}
