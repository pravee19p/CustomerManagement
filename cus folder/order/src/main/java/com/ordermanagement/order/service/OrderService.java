package com.ordermanagement.order.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.order.dto.OrderDTO;
import com.ordermanagement.order.model.Order;
import com.ordermanagement.order.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Method to convert OrderDTO to Order entity
    private Order convertToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setCustomerId(orderDTO.getCustomerId());
        order.setServiceType(orderDTO.getServiceType());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setTotalAmount(orderDTO.getTotalAmount());
        return order;
    }

    // Method to convert Order entity to OrderDTO
    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerId(order.getCustomerId());
        orderDTO.setServiceType(order.getServiceType());
        orderDTO.setOrderDate(order.getOrderDate());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setTotalAmount(order.getTotalAmount());
        return orderDTO;
    }

    // Adding an order using OrderDTO
    public OrderDTO addOrder(OrderDTO orderDTO) {
        Order order = convertToEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    // Updating an order using OrderDTO
    public OrderDTO updateOrder(long orderId, OrderDTO orderDTO) {
        Optional<Order> op = orderRepository.findById(orderId);
        if (op.isPresent()) {
            Order order = op.get();
            order.setOrderDate(orderDTO.getOrderDate());
            order.setServiceType(orderDTO.getServiceType());
            order.setOrderStatus(orderDTO.getOrderStatus());
            order.setTotalAmount(orderDTO.getTotalAmount());
            Order updatedOrder = orderRepository.save(order);
            return convertToDTO(updatedOrder);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    // Deleting an order
    public void deleteOrder(long orderId) {
        orderRepository.deleteById(orderId);
    }

    // Retrieving all orders as DTOs
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                     .map(this::convertToDTO)
                     .collect(Collectors.toList());
    }
}























// package com.ordermanagement.order.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.ordermanagement.order.model.Order;
// import com.ordermanagement.order.repository.OrderRepository;

// @Service
// public class OrderService {

//   @Autowired
//   OrderRepository orderRepository;

// public Order addOrder(Order order) {
//    return orderRepository.save(order);
// }

// public Order updateOrder(long OrderId, Order order) {
//     Optional<Order> op=orderRepository.findById(OrderId);
//     if(op.isPresent()){
//         Order order2=op.get();
//         order2.setOrderDate(order.getOrderDate());
//         order2.setServiceType(order.getServiceType());
//         return orderRepository.save(order2);
//     }
//     else{
//         throw new RuntimeException("not found");
//     }
    
// }

// public void deleteOrder(long orderId) {
//     orderRepository.deleteById(orderId);
// }

// public List<Order> getOrders() {
//   return orderRepository.findAll();
// }
// }
