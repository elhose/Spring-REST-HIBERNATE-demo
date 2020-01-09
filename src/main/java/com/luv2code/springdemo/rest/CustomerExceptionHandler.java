package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerException> handleCustomerNotFoundException(CustomerNotFoundException e) {

        CustomerException customerException = new CustomerException();
        customerException.setMessage(e.getMessage());
        customerException.setStatus(HttpStatus.NOT_FOUND.value());
        customerException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerException> handleAllExceptions(Exception e) {

        CustomerException customerException = new CustomerException();
        customerException.setMessage(e.getMessage());
        customerException.setStatus(HttpStatus.BAD_REQUEST.value());
        customerException.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(customerException, HttpStatus.BAD_REQUEST);
    }
}
