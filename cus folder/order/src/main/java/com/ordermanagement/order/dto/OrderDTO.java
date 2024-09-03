package com.ordermanagement.order.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {
    private Long orderId;
    private Long customerId;
    private String serviceType;
    private LocalDateTime orderDate;
    private String orderStatus;
    private BigDecimal totalAmount;
}
