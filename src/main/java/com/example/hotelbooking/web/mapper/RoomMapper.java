package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.web.dto.room.RoomResponse;
import com.example.hotelbooking.web.dto.room.RoomUpsertRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoomMapper {
    RoomResponse roomToRoomResponse(Room room);
    Room roomUpsertRequestToRoom(RoomUpsertRequest request);
    @Mapping(source = "userId", target = "id")
    Room roomUpsertRequestToRoom(Long roomId, RoomUpsertRequest request);
}
