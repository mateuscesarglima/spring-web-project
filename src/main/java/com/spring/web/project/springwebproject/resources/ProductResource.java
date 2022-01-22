package com.spring.web.project.springwebproject.resources;

import java.util.List;

import com.spring.web.project.springwebproject.entities.Product;
import com.spring.web.project.springwebproject.services.ProductServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        ResponseEntity<List<Product>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<Product> list = productServices.findAll();

        if(!list.isEmpty()){
            response = ResponseEntity.ok().body(list);
        }

        return response;

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        ResponseEntity<Product> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        Product product = productServices.findById(id);

        if(product != null){
            response = ResponseEntity.ok().body(product);
        }

        return response;

        
    }
}
