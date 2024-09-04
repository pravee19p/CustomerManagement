package com.example.customersupport.service;
import com.example.customersupport.model.SupportRequest;
import com.example.customersupport.repository.SupportRequestRepository;
import com.example.customersupport.client.CustomerClient;
import com.example.customersupport.client.SubscriptionClient;
import com.example.customersupport.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SupportRequestService {
   
    @Autowired
    private SupportRequestRepository supportRequestRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private SubscriptionClient subscriptionClient;

    @Autowired
    private OrderClient orderClient;

    public List<SupportRequest> getAllSupportRequests() {
        return supportRequestRepository.findAll();
    }

    public Optional<SupportRequest> getSupportRequestById(Long id) {
        return supportRequestRepository.findById(id);
    }

    public SupportRequest saveSupportRequest(SupportRequest supportRequest) {
        // Validate customer, subscription, and order
        if (customerClient.getCustomerById(supportRequest.getCustomerProfile().getCustomerId()) == null ||
            (supportRequest.getSubscription() != null && subscriptionClient.getSubscriptionById(supportRequest.getSubscription().getSubscriptionId()) == null) ||
            (supportRequest.getOrder() != null && orderClient.getOrderById(supportRequest.getOrder().getOrderId()) == null)) {
            throw new RuntimeException("Invalid customer, subscription, or order");
        }

        return supportRequestRepository.save(supportRequest);
    }

    public void deleteSupportRequest(Long id) {
        supportRequestRepository.deleteById(id);
    }
}



