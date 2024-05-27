package com.example.hotelbooking.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(MessageFormat.format("User with ID ({0}) not found.", id.toString()));
    }

    public UserNotFoundException(String username) {
        super(MessageFormat.format("User with username ({0}) not found.", username.toString()));
    }
}
