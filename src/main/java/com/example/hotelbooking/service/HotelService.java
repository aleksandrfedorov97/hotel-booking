package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Hotel;

import java.util.List;


public interface HotelService {
    List<Hotel> findAll();
    Hotel findById(Long id);
    Hotel create(Hotel hotel);
    Hotel update(Hotel hotel);
    void deleteById(Long id);
}
