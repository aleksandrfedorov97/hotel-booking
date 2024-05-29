package com.example.hotelbooking.exception;

import java.text.MessageFormat;

public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Long id) {
        super(MessageFormat.format("Hotel with ID ({0}) not found.", id.toString()));
    }
}
