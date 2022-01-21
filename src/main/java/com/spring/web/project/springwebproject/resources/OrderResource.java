package com.spring.web.project.springwebproject.resources;

import java.util.List;

import com.spring.web.project.springwebproject.entities.Order;
import com.spring.web.project.springwebproject.services.OrderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        
        List<Order> list = orderServices.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){

        Order order = orderServices.findById(id);

        return ResponseEntity.ok().body(order);
    }
    
}
