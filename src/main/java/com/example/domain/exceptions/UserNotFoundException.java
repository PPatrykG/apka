package com.example.domain.exceptions;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException(String userId) {
        super("User not found: " + userId);
    }
}
