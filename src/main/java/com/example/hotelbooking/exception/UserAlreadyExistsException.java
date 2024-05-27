package com.example.hotelbooking.exception;

import java.text.MessageFormat;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String parameterName, String value) {
        super(MessageFormat.format("User with {0} ({1}) already exists.", parameterName, value));
    }
}
