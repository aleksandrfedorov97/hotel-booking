package com.example.hotelbooking.web.controller;


import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.service.BookingService;
import com.example.hotelbooking.web.dto.booking.BookingListResponse;
import com.example.hotelbooking.web.dto.booking.BookingResponse;
import com.example.hotelbooking.web.dto.booking.BookingUpsertRequest;
import com.example.hotelbooking.web.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @GetMapping
    public ResponseEntity<BookingListResponse> findAll() {
        return ResponseEntity.ok(
                bookingMapper.bookingListToBookingListResponse(bookingService.findAll())
        );
    }

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody BookingUpsertRequest request) {
        Booking createdBooking = bookingService.create(request);

        return ResponseEntity.ok(bookingMapper.bookingToHotelResponse(createdBooking));
    }
}
