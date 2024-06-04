package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.web.dto.booking.BookingUpsertRequest;

import java.util.List;

public interface BookingService {
    List<Booking> findAll();
    Booking findById(Long id);
    Booking create(BookingUpsertRequest request);
}
