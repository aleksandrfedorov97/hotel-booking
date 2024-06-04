package com.example.hotelbooking.web.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HotelListResponse {
    private List<HotelResponse> hotels;
}
