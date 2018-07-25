package com.joshimo.cinema.exception;

public class PermissionException extends RuntimeException {
    public PermissionException() {
        super("Operation is not permitted!");
    }
}
