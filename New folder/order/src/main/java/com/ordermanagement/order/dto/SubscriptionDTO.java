package com.ordermanagement.order.dto;

import java.time.LocalDate;
import lombok.Data;
@Data
public class SubscriptionDTO {
    private Long id;
    private Long customerId;
    private String planName;  // Should match `plan` in SubscriptionPlan
    private LocalDate startDate;  // If used
    
    public SubscriptionDTO() {
    }
    public SubscriptionDTO(Long id, Long customerId, String planName, LocalDate startDate) {
        this.id = id;
        this.customerId = customerId;
        this.planName = planName;
        this.startDate = startDate;
    }
    
}
