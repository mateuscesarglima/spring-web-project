package com.spring.web.project.springwebproject.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.spring.web.project.springwebproject.services.exceptions.DatabaseException;
import com.spring.web.project.springwebproject.services.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Intercepta as exceções que acontecem para que este objeto possa executar um possível tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resource not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandartError> resourceNotFound(DatabaseException e, HttpServletRequest request) {
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }


}
