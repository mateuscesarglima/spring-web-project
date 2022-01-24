package com.spring.web.project.springwebproject.resources;

import java.util.List;

import com.spring.web.project.springwebproject.entities.Category;
import com.spring.web.project.springwebproject.services.CategoryServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        ResponseEntity<List<Category>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<Category> list = categoryServices.findAll();

        if (!list.isEmpty()) {
            response = new ResponseEntity<>(list, HttpStatus.OK);
        }

        return response;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable(name = "id") Long id) {

        ResponseEntity<Category> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Category category = categoryServices.findById(id);

        if (category != null) {
            response = new ResponseEntity<>(category, HttpStatus.OK);
        }

        return response;

    }

}
