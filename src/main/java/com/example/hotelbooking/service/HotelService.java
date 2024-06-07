package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.web.dto.hotel.HotelFilter;
import com.example.hotelbooking.web.dto.hotel.HotelUpsertRequest;

import java.util.List;


public interface HotelService {
    List<Hotel> findAll();
    List<Hotel> filterBy(HotelFilter hotelFilter);
    Hotel findById(Long id);
    Hotel create(HotelUpsertRequest request);
    Hotel update(Long id, HotelUpsertRequest request);
    Hotel updateRating(Long id, Integer mark);
    void deleteById(Long id);
}
