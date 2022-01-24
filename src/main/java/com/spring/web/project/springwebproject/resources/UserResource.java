package com.spring.web.project.springwebproject.resources;

import java.util.List;

import com.spring.web.project.springwebproject.entities.User;
import com.spring.web.project.springwebproject.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> list = userServices.findAll();

        return ResponseEntity.ok().body(list);
        
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User obj = userServices.findById(id);
        
        return ResponseEntity.ok().body(obj);   

    }
    
}
