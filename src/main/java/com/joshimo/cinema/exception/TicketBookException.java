package com.joshimo.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TicketBookException extends RuntimeException {
    public TicketBookException(String message) {
        super(message);
    }
}
