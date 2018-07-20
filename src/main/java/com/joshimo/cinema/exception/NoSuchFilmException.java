package com.joshimo.cinema.exception;

public class NoSuchFilmException extends RuntimeException {
    public NoSuchFilmException() {
        super("Film not exist in Database");
    }
}
