package com.example.feedbackmanagement.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-support-service", url = "http://localhost:8084")
public interface SupportClient {
    @GetMapping("/support-requests/{id}")
    Object getSupportRequestById(@PathVariable("id") Long id);
}

