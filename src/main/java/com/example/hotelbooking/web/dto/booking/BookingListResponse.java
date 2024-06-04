package com.example.hotelbooking.web.dto.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingListResponse {
    private List<BookingResponse> bookings;
}
