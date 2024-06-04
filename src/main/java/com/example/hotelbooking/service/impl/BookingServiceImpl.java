package com.example.hotelbooking.service.impl;

import com.example.hotelbooking.entity.Booking;
import com.example.hotelbooking.entity.BookingDetails;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.exception.BookingDateAlreadyLockingException;
import com.example.hotelbooking.exception.BookingNotFoundException;
import com.example.hotelbooking.repository.BookingDetailsRepository;
import com.example.hotelbooking.repository.BookingRepository;
import com.example.hotelbooking.service.BookingService;
import com.example.hotelbooking.web.dto.booking.BookingUpsertRequest;
import com.example.hotelbooking.web.mapper.BookingMapper;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Interval;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingMapper bookingMapper;
    private final BookingRepository bookingRepository;
    private final BookingDetailsRepository bookingDetailsRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
    }

    @Transactional
    public Booking create(BookingUpsertRequest request) {
        Booking booking = bookingMapper.bookingUpsertRequestToBooking(request);

        User user = new User();
        user.setId(1L); // ToDo: Spring Security

        booking.setUser(user);

        Booking savedBooking = bookingRepository.save(booking);

        List<BookingDetails> savedBookingDetails = new ArrayList<>();
        for (BookingDetails bookingDetails : booking.getDetails()) {
            Room room = bookingDetails.getRoom();
            Interval bookingInterval = new Interval(
                    Long.valueOf(bookingDetails.getArrivalDate().getEpochSecond()).intValue(),
                    Long.valueOf(bookingDetails.getDepartureDate().getEpochSecond()).intValue()
            );

            for (BookingDetails existedBookingDetails: room.getBookingDetails()) {
                Interval existedBookingInterval = new Interval(
                        Long.valueOf(existedBookingDetails.getArrivalDate().getEpochSecond()).intValue(),
                        Long.valueOf(existedBookingDetails.getDepartureDate().getEpochSecond()).intValue()
                );

                if (existedBookingInterval.intersection(bookingInterval) != null) {
                    throw new BookingDateAlreadyLockingException(room.getId(), bookingInterval);
                }
            }

            bookingDetails.setBooking(savedBooking);

            savedBookingDetails.add(
                    bookingDetailsRepository.save(bookingDetails)
            );
        }

        savedBooking.setDetails(savedBookingDetails);
        return savedBooking;
    }
}
