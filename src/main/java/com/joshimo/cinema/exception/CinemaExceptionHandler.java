package com.joshimo.cinema.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CinemaExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            PermissionException.class,
            NoSuchUserException.class,
            NoSuchSeanceException.class,
            NoSuchTicketException.class,
            NoSuchFilmException.class})
    public ResponseEntity<Object> handleExceptions(RuntimeException ex) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketBookException.class)
    public ResponseEntity<Object> handleException(TicketBookException ex) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<Object>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getClass().getSimpleName(), ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorEntity error = new ErrorEntity(new Date(), ex.getClass().getSimpleName(), ex.getBindingResult().toString());
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
}