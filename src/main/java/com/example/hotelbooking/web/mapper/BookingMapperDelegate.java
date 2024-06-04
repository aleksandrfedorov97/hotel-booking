package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.entity.BookingDetails;
import com.example.hotelbooking.service.RoomService;
import com.example.hotelbooking.web.dto.booking.BookingResponse;
import com.example.hotelbooking.web.dto.booking.BookingUpsertRequest;
import com.example.hotelbooking.web.dto.bookingdetails.BookingDetailsResponse;
import com.example.hotelbooking.web.dto.bookingdetails.BookingDetailsUpsertRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BookingMapperDelegate implements BookingMapper {

    @Autowired
    private RoomService roomService;
    @Autowired
    private BookingDetailsMapper bookingDetailsMapper;

    @Override
    public BookingResponse bookingToHotelResponse(Booking booking) {
        BookingResponse response = new BookingResponse();

        response.setId(booking.getId());
        response.setUserId(booking.getUser().getId());

        List<BookingDetailsResponse> bookingDetails = new ArrayList<>();

        if(booking.getDetails() != null) {
            bookingDetails = booking.getDetails().stream()
                    .map(bookingDetailsMapper::bookingDetailsToBookingDetailsResponse)
                    .collect(Collectors.toList());
        }

        response.setDetails(bookingDetails);

        return response;
    }

    @Override
    public Booking bookingUpsertRequestToBooking(BookingUpsertRequest request) {
        Booking booking = new Booking();

        List<BookingDetails> details = new ArrayList<>();

        for (BookingDetailsUpsertRequest detailsUpsertRequest : request.getDetails()) {
            BookingDetails bookingDetails = new BookingDetails();

            bookingDetails.setArrivalDate(detailsUpsertRequest.getArrivalDate());
            bookingDetails.setDepartureDate(detailsUpsertRequest.getDepartureDate());
            bookingDetails.setRoom(roomService.findById(detailsUpsertRequest.getRoomId()));

            details.add(bookingDetails);
        }

        booking.setDetails(details);

        return booking;
    }
}
