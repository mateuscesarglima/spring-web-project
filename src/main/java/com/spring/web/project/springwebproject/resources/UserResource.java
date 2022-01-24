package com.spring.web.project.springwebproject.resources;

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

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        ResponseEntity<List<User>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<User> obj = userServices.findAll();

        if (!obj.isEmpty()) {
            response = ResponseEntity.ok().body(obj);
        }

        return response;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        ResponseEntity<User> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        User obj = userServices.findById(id);

        if (obj != null) {
            response = ResponseEntity.ok().body(obj);
        }

        return response;

    }

}
