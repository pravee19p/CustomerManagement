package com.ordermanagement.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.order.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

}
