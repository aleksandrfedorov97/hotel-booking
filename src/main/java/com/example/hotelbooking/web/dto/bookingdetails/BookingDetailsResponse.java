package com.example.hotelbooking.web.dto.bookingdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingDetailsResponse {
    private Long roomId;
    private Instant arrivalDate;
    private Instant departureDate;
}
