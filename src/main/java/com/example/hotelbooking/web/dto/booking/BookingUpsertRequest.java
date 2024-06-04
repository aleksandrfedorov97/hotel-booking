package com.example.hotelbooking.web.dto.booking;

import com.example.hotelbooking.web.dto.bookingdetails.BookingDetailsUpsertRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookingUpsertRequest {
    private List<BookingDetailsUpsertRequest> details;
}
