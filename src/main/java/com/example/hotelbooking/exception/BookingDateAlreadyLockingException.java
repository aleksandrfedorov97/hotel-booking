package com.example.hotelbooking.exception;

import org.antlr.v4.runtime.misc.Interval;

import java.text.MessageFormat;
import java.time.Instant;

public class BookingDateAlreadyLockingException extends RuntimeException {
    public BookingDateAlreadyLockingException(Long roomId, Interval interval) {
        super(MessageFormat.format(
                "Room with ID ({0}) is already booked for date start at ({1}) to ({2}).",
                roomId.toString(),
                Instant.ofEpochSecond(interval.a),
                Instant.ofEpochSecond(interval.b)
        ));
    }
}
