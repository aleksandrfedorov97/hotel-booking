package com.example.hotelbooking.web.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RoomResponse {
    private Long id;
    private String name;
    private String description;
    private String number;
    private Long price;
    private Integer capacity;
    private Long hotelId;
}
