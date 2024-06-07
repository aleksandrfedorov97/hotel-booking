package com.example.hotelbooking.web.validation;

import com.example.hotelbooking.web.dto.hotel.HotelFilter;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HotelFilterValidValidator implements ConstraintValidator<HotelFilterValid, HotelFilter> {
    @Override
    public boolean isValid(HotelFilter hotelFilter, ConstraintValidatorContext constraintValidatorContext) {
        if (hotelFilter.getPageNumber() == null || hotelFilter.getPageSize() == null) {
            return false;
        }

        return true;
    }
}
