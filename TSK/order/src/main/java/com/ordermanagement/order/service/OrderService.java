package com.ordermanagement.order.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.order.model.Order;
import com.ordermanagement.order.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
        @Autowired
        private OrderRepository orderRepository;
    
        public List<Order> getAllOrders() {
            return orderRepository.findAll();
        }
    
        public Optional<Order> getOrdersByCustomerId(Long customerId) {
            return orderRepository.findById(customerId);
        }
    
        public Optional<Order> getOrderById(Long id) {
            return orderRepository.findById(id);
        }
    
        public Order createOrder(Order order) {
            order.setOrderDate(LocalDate.now());
            order.setStatus("Pending");
            return orderRepository.save(order);
        }
    
        public Order updateOrder(Long id, Order orderDetails) {
            Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    
            order.setServiceType(orderDetails.getServiceType());
            order.setStatus(orderDetails.getStatus());
            order.setCompletionDate(orderDetails.getCompletionDate());
    
            return orderRepository.save(order);
        }
    
        public void deleteOrder(Long id) {
            orderRepository.deleteById(id);
        }
    }
    




