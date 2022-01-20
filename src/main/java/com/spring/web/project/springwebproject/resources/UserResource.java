package com.spring.web.project.springwebproject.resources;


import com.spring.web.project.springwebproject.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){

        User u1 = new User(1L, "joao", "joao@gmail.com", "123123123", "123123123");

        return ResponseEntity.ok().body(u1);
    }
    
}
