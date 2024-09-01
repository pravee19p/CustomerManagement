package com.example.ordermanagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-subscription-service", url = "http://localhost:8082")
public interface SubscriptionClient {

    @GetMapping("/subscriptions/{id}")
    Object getSubscriptionById(@PathVariable("id") Long id);
}