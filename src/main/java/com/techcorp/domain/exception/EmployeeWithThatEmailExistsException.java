package com.techcorp.domain.exception;

public class EmployeeWithThatEmailExistsException extends RuntimeException {
    public EmployeeWithThatEmailExistsException(String message) {
        super(message);
    }
}
