package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.web.dto.booking.BookingListResponse;
import com.example.hotelbooking.web.dto.booking.BookingResponse;
import com.example.hotelbooking.web.dto.booking.BookingUpsertRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(BookingMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingMapper {
    BookingResponse bookingToHotelResponse(Booking booking);
    Booking bookingUpsertRequestToBooking(BookingUpsertRequest request);

    default BookingListResponse bookingListToBookingListResponse(List<Booking> bookings) {
        BookingListResponse bookingListResponse = new BookingListResponse();

        bookingListResponse.setBookings(
                bookings.stream()
                        .map(this::bookingToHotelResponse)
                        .collect(Collectors.toList())
        );

        return bookingListResponse;
    }
}
