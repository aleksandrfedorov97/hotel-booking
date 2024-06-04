package com.example.hotelbooking.exception;

import java.text.MessageFormat;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long id) {
        super(MessageFormat.format("Booking with ID ({0}) not found.", id.toString()));
    }
}
