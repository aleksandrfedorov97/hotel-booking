package com.example.hotelbooking.service.impl;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.exception.RoomNotFoundException;
import com.example.hotelbooking.repository.RoomRepository;
import com.example.hotelbooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    public Room create(Room room) {
        return roomRepository.save(room);
    }

    public Room update(Room room) {
        Room existedRoom = findById(room.getId());

        if (StringUtils.hasText(room.getName())) {
            existedRoom.setName(room.getName());
        }

        if (StringUtils.hasText(room.getDescription())) {
            existedRoom.setDescription(room.getDescription());
        }

        if (StringUtils.hasText(room.getNumber())) {
            existedRoom.setNumber(room.getNumber());
        }

        if (room.getPrice() != null) {
            existedRoom.setPrice(room.getPrice());
        }

        if (room.getCapacity() != null) {
            existedRoom.setCapacity(room.getCapacity());
        }

        return roomRepository.save(room);
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
