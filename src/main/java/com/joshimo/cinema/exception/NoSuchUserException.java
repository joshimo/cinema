package com.joshimo.cinema.exception;

public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
        super("User not found!");
    }
}
