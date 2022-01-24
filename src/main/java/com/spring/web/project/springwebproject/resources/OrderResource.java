package com.spring.web.project.springwebproject.resources;

import java.util.List;

import com.spring.web.project.springwebproject.entities.Order;
import com.spring.web.project.springwebproject.services.OrderServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderServices service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        ResponseEntity<List<Order>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<Order> list = service.findAll();

        if (!list.isEmpty()) {
            response = ResponseEntity.ok().body(list);
        }

        return response;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {

        ResponseEntity<Order> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Order order = service.findById(id);

        if (order != null) {
            response = ResponseEntity.ok().body(order);
        }

        return response;

    }

}
