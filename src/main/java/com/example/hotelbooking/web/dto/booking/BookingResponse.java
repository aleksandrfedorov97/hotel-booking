package com.example.hotelbooking.web.dto.booking;

import com.example.hotelbooking.web.dto.bookingdetails.BookingDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingResponse {
    private Long id;
    private Long userId;
    private List<BookingDetailsResponse> details;
}
