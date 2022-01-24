package com.spring.web.project.springwebproject.services;

import java.util.List;
import java.util.Optional;

import com.spring.web.project.springwebproject.entities.User;
import com.spring.web.project.springwebproject.repositories.UserRepository;
import com.spring.web.project.springwebproject.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

}
