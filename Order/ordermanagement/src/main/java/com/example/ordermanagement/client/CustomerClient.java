package com.example.ordermanagement.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-profile-service", url = "http://localhost:8081")

public interface CustomerClient {
    
    @GetMapping("/customers/{id}")
    Object getCustomerById(@PathVariable("id") Long id);
}



