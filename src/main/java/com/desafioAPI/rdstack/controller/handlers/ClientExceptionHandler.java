package com.desafioAPI.rdstack.controller.handlers;

import com.desafioAPI.rdstack.dto.CustomError;
import com.desafioAPI.rdstack.dto.ValidationError;
import com.desafioAPI.rdstack.services.exceptions.DataBaseException;
import com.desafioAPI.rdstack.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ClientExceptionHandler {
     @ExceptionHandler(ResourceNotFoundException.class)
     public ResponseEntity<CustomError> resourcceNotFound(ResourceNotFoundException e, HttpServletRequest request){
         HttpStatus status = HttpStatus.NOT_FOUND;
         CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
         return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> resourcceNotFound(DataBaseException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> MethodArgumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados inválidos!", request.getRequestURI());
        for(FieldError f : e.getBindingResult().getFieldErrors()){
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}
