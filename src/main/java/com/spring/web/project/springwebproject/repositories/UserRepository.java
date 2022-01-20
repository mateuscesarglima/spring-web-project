package com.spring.web.project.springwebproject.repositories;

import com.spring.web.project.springwebproject.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
