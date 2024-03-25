package com.tmane.springbootmvcdemo.exception;


public class CompanyNoSuchElementException extends RuntimeException {
    private final Long id;

    public CompanyNoSuchElementException(String message, Long id) {
        super(message);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
