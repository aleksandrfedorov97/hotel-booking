package com.example.hotelbooking.web.dto.hotel;

import com.example.hotelbooking.web.validation.HotelFilterValid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
@HotelFilterValid
public class HotelFilter {
    private Integer pageSize;
    private Integer pageNumber;
    private String name;
    private String title;
    private String city;
    private String address;
    private Integer maxDistanceFromCenter;
    private BigDecimal minRating;
}
