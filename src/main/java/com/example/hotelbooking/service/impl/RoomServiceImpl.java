package com.example.hotelbooking.service.impl;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.exception.RoomNotFoundException;
import com.example.hotelbooking.repository.RoomRepository;
import com.example.hotelbooking.service.RoomService;
import com.example.hotelbooking.web.dto.room.RoomUpsertRequest;
import com.example.hotelbooking.web.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    public Room create(RoomUpsertRequest request) {
        Room room = roomMapper.roomUpsertRequestToRoom(request);

        return roomRepository.save(room);
    }

    public Room update(Long id, RoomUpsertRequest request) {
        Room room = roomMapper.roomUpsertRequestToRoom(id, request);

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
