package com.spring.web.project.springwebproject.repositories;

import com.spring.web.project.springwebproject.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
