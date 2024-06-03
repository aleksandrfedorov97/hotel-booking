package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.service.HotelService;
import com.example.hotelbooking.web.dto.room.RoomUpsertRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RoomMapperDelegate implements RoomMapper {
    @Autowired
    private HotelService hotelService;

    @Override
    public Room roomUpsertRequestToRoom(RoomUpsertRequest request) {
        Room room = new Room();

        room.setName(request.getName());
        room.setDescription(request.getDescription());
        room.setNumber(request.getNumber());
        room.setPrice(request.getPrice());
        room.setCapacity(request.getCapacity());

        Hotel hotel = hotelService.findById(request.getHotelId());

        room.setHotel(hotel);

        return room;
    }
}
