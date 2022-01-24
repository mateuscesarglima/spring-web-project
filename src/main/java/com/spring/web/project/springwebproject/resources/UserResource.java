package com.spring.web.project.springwebproject.resources;

import java.net.URI;
import java.util.List;

import com.spring.web.project.springwebproject.entities.User;
import com.spring.web.project.springwebproject.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        ResponseEntity<List<User>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<User> obj = service.findAll();

        if (!obj.isEmpty()) {
            response = ResponseEntity.ok().body(obj);
        }

        return response;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        ResponseEntity<User> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        User obj = service.findById(id);

        if (obj != null) {
            response = ResponseEntity.ok().body(obj);
        }

        return response;

    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){

        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);

    }
}
