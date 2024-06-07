package com.example.hotelbooking.web.dto.hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HotelResponse {
    private Long id;
    private String name;
    private String title;
    private String city;
    private String address;
    private String distanceFromCenter;
    private BigDecimal rating;
    private Integer numberOfRating;

    public BigDecimal getRating() {
        rating = rating.setScale(1, 4);
        return rating;
    }
}
