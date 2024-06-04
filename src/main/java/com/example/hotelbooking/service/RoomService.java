package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.web.dto.room.RoomUpsertRequest;

public interface RoomService {
    Room findById(Long id);
    Room create(RoomUpsertRequest request);
    Room update(Long id, RoomUpsertRequest request);
    void deleteById(Long id);
}
