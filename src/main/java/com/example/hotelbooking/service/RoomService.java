package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Room;

public interface RoomService {
    Room findById(Long id);
    Room create(Room room);
    Room update(Room room);
    void deleteById(Long id);
}
