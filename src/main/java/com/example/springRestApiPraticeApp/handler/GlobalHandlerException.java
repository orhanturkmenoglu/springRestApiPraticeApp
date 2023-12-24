package com.example.springRestApiPraticeApp.handler;

import com.example.springRestApiPraticeApp.exception.CustomerErrorResponce;
import com.example.springRestApiPraticeApp.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalHandlerException extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponce> getCustomerNotFoundException(CustomerNotFoundException exception){

        CustomerErrorResponce responce = new CustomerErrorResponce();
        responce.setStatus(HttpStatus.NOT_FOUND.value());
        responce.setMessage(exception.getMessage());
        responce.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(responce, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponce> getCustomerNotFoundException(Exception exception){

        CustomerErrorResponce responce = new CustomerErrorResponce();
        responce.setStatus(HttpStatus.BAD_REQUEST.value());
        responce.setMessage(exception.getMessage());
        responce.setDateTime(LocalDateTime.now());

        return new ResponseEntity<>(responce, HttpStatus.NOT_FOUND);
    }
}
