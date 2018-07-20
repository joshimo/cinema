package com.joshimo.cinema.exception;

public class NoSuchSeanceException extends RuntimeException {
    public NoSuchSeanceException() {
        super("Seance not found!");
    }
}
