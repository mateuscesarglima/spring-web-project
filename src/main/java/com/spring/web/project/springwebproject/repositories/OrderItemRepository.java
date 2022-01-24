package com.spring.web.project.springwebproject.repositories;

import com.spring.web.project.springwebproject.entities.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
}
