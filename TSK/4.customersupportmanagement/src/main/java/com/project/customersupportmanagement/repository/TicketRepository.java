package com.project.customersupportmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.customersupportmanagement.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
