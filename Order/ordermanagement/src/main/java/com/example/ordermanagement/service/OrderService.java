package com.example.ordermanagement.service;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.client.CustomerClient;
import com.example.ordermanagement.client.SubscriptionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private SubscriptionClient subscriptionClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        // Validate customer and subscription
        if (customerClient.getCustomerById(order.getCustomerProfile().getCustomerId()) == null ||
            subscriptionClient.getSubscriptionById(order.getSubscription().getSubscriptionId()) == null) {
            throw new RuntimeException("Invalid customer or subscription");
        }

        // Set start and end dates
        order.setStartDate(LocalDate.now());
        order.setEndDate(order.getStartDate().plusDays(30));

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}


}
