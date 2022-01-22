package com.spring.web.project.springwebproject.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super("Resource not not found. Id " + id);
    }

}
