package com.example.hotelbooking.service.impl;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.exception.HotelNotFoundException;
import com.example.hotelbooking.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HotelServiceImpl {

    private final HotelRepository hotelRepository;

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new HotelNotFoundException(id));
    }

    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel update(Hotel hotel) {
        Hotel existedHotel = findById(hotel.getId());

        if (StringUtils.hasText(hotel.getName())) {
            existedHotel.setName(hotel.getName());
        }

        if (StringUtils.hasText(hotel.getTitle())) {
            existedHotel.setTitle(hotel.getTitle());
        }

        if (StringUtils.hasText(hotel.getCity())) {
            existedHotel.setCity(hotel.getCity());
        }

        if (StringUtils.hasText(hotel.getAddress())) {
            existedHotel.setAddress(hotel.getAddress());
        }

        if (StringUtils.hasText(hotel.getDistanceFromCenter())) {
            existedHotel.setDistanceFromCenter(hotel.getDistanceFromCenter());
        }

        if (StringUtils.hasText(hotel.getRating())) {
            existedHotel.setRating(hotel.getRating());
        }

        if (hotel.getNumberOfRatings() != null) {
            existedHotel.setNumberOfRatings(hotel.getNumberOfRatings());
        }

        return hotelRepository.save(hotel);
    }

    public void deleteById(Long id) {
        hotelRepository.deleteById(id);
    }
}
