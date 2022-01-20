package com.spring.web.project.springwebproject.repositories;

import com.spring.web.project.springwebproject.entities.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
