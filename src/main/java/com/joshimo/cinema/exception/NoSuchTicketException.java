package com.joshimo.cinema.exception;

public class NoSuchTicketException extends RuntimeException {
    public NoSuchTicketException() {
        super("Ticket not found!");
    }
}
