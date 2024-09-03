package com.ordermanagement.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ordermanagement.order.service.OrderService;
import com.ordermanagement.order.dto.OrderDTO;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Get all orders
    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> orders = orderService.getOrders();
        return ResponseEntity.ok(orders);
    }

    // Add a new order
    @PostMapping()
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.addOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    // Update an existing order
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable long id, @RequestBody OrderDTO orderDTO) {
        try {
            OrderDTO updatedOrder = orderService.updateOrder(id, orderDTO);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}


























// package com.ordermanagement.order.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RestController;

// import com.ordermanagement.order.model.Order;
// import com.ordermanagement.order.service.OrderService;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;




// @RestController
// @RequestMapping("/orders")
// public class OrderController {

//     @Autowired
//     OrderService orderService;

//     @GetMapping()
//     public ResponseEntity<List<Order>> getOrders() {
//      return  ResponseEntity.ok(orderService.getOrders());   
//     }
    
//     @PostMapping()
//     public ResponseEntity<Order> addOrder(@RequestBody Order order) {
//         return ResponseEntity.ok(orderService.addOrder(order));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody Order order) {
        
//         try{
//         Order ord=orderService.updateOrder(id,order);
//         return new ResponseEntity<>(ord,HttpStatus.OK);

//         }catch(RuntimeException e){
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//         }
//     }
    
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Order> deleteOrder(@PathVariable("id") long OrderId){
//         orderService.deleteOrder(OrderId);
//          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//     }
// }
