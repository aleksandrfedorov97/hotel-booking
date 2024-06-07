package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.web.dto.hotel.HotelFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public interface HotelSpecification {
    static Specification<Hotel> withFilter(HotelFilter hotelFilter) {
        return Specification.where(byName(hotelFilter.getName()))
                .and(byTitle(hotelFilter.getTitle()))
                .and(byCity(hotelFilter.getCity()))
                .and(byAddress(hotelFilter.getAddress()))
                .and(byMaxDistanceFromCenter(hotelFilter.getMaxDistanceFromCenter()))
                .and(byMinRating(hotelFilter.getMinRating()));
    }

    static Specification<Hotel> byName(String name) {
        return (root, query, criteriaBuilder) -> {
            if(!StringUtils.hasText(name)){
                return null;
            }

            return criteriaBuilder.equal(root.get("name"), name);
        };
    }

    static Specification<Hotel> byTitle(String title) {
        return (root, query, criteriaBuilder) -> {
            if(!StringUtils.hasText(title)){
                return null;
            }

            return criteriaBuilder.equal(root.get("title"), title);
        };
    }

    static Specification<Hotel> byCity(String city) {
        return (root, query, criteriaBuilder) -> {
            if(!StringUtils.hasText(city)){
                return null;
            }

            return criteriaBuilder.equal(root.get("city"), city);
        };
    }

    static Specification<Hotel> byAddress(String address) {
        return (root, query, criteriaBuilder) -> {
            if(!StringUtils.hasText(address)){
                return null;
            }

            return criteriaBuilder.equal(root.get("address"), address);
        };
    }

    static Specification<Hotel> byMaxDistanceFromCenter(Integer maxDistanceFromCenter) {
        return (root, query, criteriaBuilder) -> {
            if(maxDistanceFromCenter == null){
                return null;
            }

            return criteriaBuilder.lessThanOrEqualTo(root.get("distanceFromCenter"), maxDistanceFromCenter);
        };
    }

    static Specification<Hotel> byMinRating(BigDecimal rating) {
        return (root, query, criteriaBuilder) -> {
            if(rating == null){
                return null;
            }

            return criteriaBuilder.greaterThanOrEqualTo(root.get("rating"), rating);
        };
    }
}
