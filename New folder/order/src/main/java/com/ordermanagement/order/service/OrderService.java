package com.ordermanagement.order.service;
import com.ordermanagement.order.model.Order;
import com.ordermanagement.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    
           
            order.setStatus(orderDetails.getStatus());
            
    
            return orderRepository.save(order);
        }
    
        public void deleteOrder(Long id) {
            orderRepository.deleteById(id);
        }
    }
    

//     @Service
// public class OrderService {

//     @Autowired
//     private OrderRepository orderRepository;

//     @Autowired
//     private RestTemplate restTemplate;

//     private final String subscriptionServiceUrl = "http://localhost:8081/api/subscriptions";

//     public List<Order> getAllOrders() {
//         return orderRepository.findAll();
//     }

//     public Optional<Order> getOrderById(Long id) {
//         return orderRepository.findById(id);
//     }

//     public Order createOrder(Order order) {
//         order.setOrderDate(LocalDate.now());
//         order.setStatus("Pending");
        
//         // Create a subscription for the order
//         SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
//         subscriptionDTO.setCustomerId(order.getCustomerId());
//         subscriptionDTO.setPlanName(order.getServiceType());
//         subscriptionDTO.setStartDate(order.getOrderDate());

//         SubscriptionDTO createdSubscription = createSubscription(subscriptionDTO);
        
//         // You can update the order with subscription details if needed
//         // order.setSubscriptionId(createdSubscription.getId()); // Example
        
//         return orderRepository.save(order);
//     }

//     private SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
//         return restTemplate.postForObject(subscriptionServiceUrl, subscriptionDTO, SubscriptionDTO.class);
//     }

//     public Order updateOrder(Long id, Order orderDetails) {
//         Order order = orderRepository.findById(id)
//                 .orElseThrow(() -> new RuntimeException("Order not found"));

//         order.setServiceType(orderDetails.getServiceType());
//         order.setStatus(orderDetails.getStatus());
//         order.setCompletionDate(orderDetails.getCompletionDate());

//         return orderRepository.save(order);
//     }

//     public void deleteOrder(Long id) {
//         orderRepository.deleteById(id);
//     }

//     public Optional<Order> getOrdersByCustomerId(Long customerId) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getOrdersByCustomerId'");
//     }
// }





