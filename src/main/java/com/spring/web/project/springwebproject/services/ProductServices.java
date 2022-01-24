package com.spring.web.project.springwebproject.services;

import java.util.List;
import java.util.Optional;

import com.spring.web.project.springwebproject.entities.Product;
import com.spring.web.project.springwebproject.repositories.ProductRepository;
import com.spring.web.project.springwebproject.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {

        return repository.findAll();

    }

    public Product findById(Long id) {

        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

}
