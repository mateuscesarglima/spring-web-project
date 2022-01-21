package com.spring.web.project.springwebproject.services;

import java.util.List;
import java.util.Optional;

import com.spring.web.project.springwebproject.entities.Category;
import com.spring.web.project.springwebproject.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        return repository.findAll();

    }

    public Category findById(Long id) {

        Optional<Category> obj = repository.findById(id);

        return obj.get();
    }
}
