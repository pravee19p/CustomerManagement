package com.example.feedbackmanagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-management-service", url = "http://localhost:8083")
public interface OrderClient {
    @GetMapping("/orders/{id}")
    Object getOrderById(@PathVariable("id") Long id);
}
