package com.joshimo.cinema.exception;

import java.util.Date;

public class ErrorEntity {

    private Date date;
    private String exception;
    private String message;

    public ErrorEntity() {
    }

    public ErrorEntity(Date date, String exception, String message) {
        this.date = date;
        this.exception = exception;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getException() {
        return exception;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
