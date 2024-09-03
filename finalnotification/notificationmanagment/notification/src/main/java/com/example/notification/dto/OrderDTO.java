package com.example.notification.dto;

import java.time.LocalDate;

public class OrderDTO {
    private Long id;
        private Long customerId;
        private String plan;
        private String status;
        private LocalDate orderDate;
        public OrderDTO() {
        }
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
        public String getPlan() {
            return plan;
        }
        public void setPlan(String plan) {
            this.plan = plan;
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
        @Override
        public String toString() {
            return "OrderDTO [id=" + id + ", customerId=" + customerId + ", plan=" + plan + ", status=" + status
                    + ", orderDate=" + orderDate + "]";
        }
        public OrderDTO(Long id, Long customerId, String plan, String status, LocalDate orderDate) {
            this.id = id;
            this.customerId = customerId;
            this.plan = plan;
            this.status = status;
            this.orderDate = orderDate;
        }
        

}
