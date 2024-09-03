package com.example.servicesubscription.model;

public enum SubscriptionPlanType {
    
        BASIC(30),
        STANDARD(60),
        PREMIUM(90),
        ENTERPRISE(365);
    
        private final int timePeriod;
    
        SubscriptionPlanType(int timePeriod) {
            this.timePeriod = timePeriod;
        }
    
        public int getTimePeriod() {
            return timePeriod;
        }
    
        public static SubscriptionPlanType fromString(String plan) {
            for (SubscriptionPlanType type : SubscriptionPlanType.values()) {
                if (type.name().equalsIgnoreCase(plan)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("No enum constant " + plan);
        }
    }


