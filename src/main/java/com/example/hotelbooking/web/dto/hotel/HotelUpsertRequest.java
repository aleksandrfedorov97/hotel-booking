package com.example.hotelbooking.web.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HotelUpsertRequest {
    private String name;
    private String title;
    private String city;
    private String address;
    private String distanceFromCenter;
}
