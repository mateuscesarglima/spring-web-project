package com.spring.web.project.springwebproject.services;

import java.util.List;
import java.util.Optional;

import com.spring.web.project.springwebproject.entities.Order;
import com.spring.web.project.springwebproject.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){

        return repository.findAll();

    }

    public Order findById(Long id){

        Optional<Order> obj = repository.findById(id);
        return obj.get();

    }

}
