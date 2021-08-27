package com.coki.employeemanager.exception;

public class UserNotFoundExcepion extends RuntimeException {
    public UserNotFoundExcepion(String message) {
        super(message);
    }
}
