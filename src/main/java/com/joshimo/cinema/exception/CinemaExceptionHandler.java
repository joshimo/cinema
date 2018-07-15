package com.joshimo.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CinemaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getMessage(), ex.getCause().getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketBookException.class)
    public final ResponseEntity<Object> handleTicketException(TicketBookException ex) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getMessage(), ex.getCause().getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY);
    }
}