package com.joshimo.cinema.exception;

import java.util.Date;

public class ErrorEntity {

    private Date date;
    private String message;
    private String cause;

    public ErrorEntity() {
    }

    public ErrorEntity(Date date, String message, String cause) {
        this.date = date;
        this.message = message;
        this.cause = cause;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getCause() {
        return cause;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
