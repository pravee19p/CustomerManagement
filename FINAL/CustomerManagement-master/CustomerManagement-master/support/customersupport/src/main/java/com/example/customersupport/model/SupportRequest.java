package com.example.customersupport.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class SupportRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerProfile customerProfile;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = true)
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    private String issue;
    private String status;
}


