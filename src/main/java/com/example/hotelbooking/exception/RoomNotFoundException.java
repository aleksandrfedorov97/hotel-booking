package com.example.hotelbooking.exception;

import java.text.MessageFormat;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super(MessageFormat.format("Room with ID ({0}) not found.", id.toString()));
    }
}
