package com.ordermanagement.order.model;
import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="Orders")
public class Order {

    
  
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        private Long customerId;
        private String serviceType;
        private String status;
        private LocalDate orderDate;
        private LocalDate completionDate;
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Long getCustomerId() {
            return customerId;
        }
        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
        public String getServiceType() {
            return serviceType;
        }
        public void setServiceType(String serviceType) {
            this.serviceType = serviceType;
        }
        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }
        public LocalDate getOrderDate() {
            return orderDate;
        }
        public void setOrderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
        }
        public LocalDate getCompletionDate() {
            return completionDate;
        }
        public void setCompletionDate(LocalDate completionDate) {
            this.completionDate = completionDate;
        }
        public Order() {
        }
        public Order(Long id, Long customerId, String serviceType, String status, LocalDate orderDate,
                LocalDate completionDate) {
            this.id = id;
            this.customerId = customerId;
            this.serviceType = serviceType;
            this.status = status;
            this.orderDate = orderDate;
            this.completionDate = completionDate;
        }
        @Override
        public String toString() {
            return "Order [id=" + id + ", customerId=" + customerId + ", serviceType=" + serviceType + ", status="
                    + status + ", orderDate=" + orderDate + ", completionDate=" + completionDate + "]";
        }
    
       
    }
    



