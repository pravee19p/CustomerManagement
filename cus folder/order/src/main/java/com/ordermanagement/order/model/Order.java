package com.ordermanagement.order.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
     private Long orderId;
    private Long customerId;
    private String serviceType;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal totalAmount;



}
