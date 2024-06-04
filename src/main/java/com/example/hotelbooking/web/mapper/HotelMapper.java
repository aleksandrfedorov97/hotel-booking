package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.web.dto.hotel.HotelListResponse;
import com.example.hotelbooking.web.dto.hotel.HotelResponse;
import com.example.hotelbooking.web.dto.hotel.HotelUpsertRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper {

    HotelResponse hotelToHotelResponse(Hotel hotel);
    Hotel hotelUpsertRequestToHotel(HotelUpsertRequest request);
    @Mapping(source = "hotelId", target = "id")
    Hotel hotelUpsertRequestToHotel(Long hotelId, HotelUpsertRequest request);

    default HotelListResponse hotelListToHotelListResponse(List<Hotel> hotels) {
        HotelListResponse hotelListResponse = new HotelListResponse();

        hotelListResponse.setHotels(
                hotels.stream()
                        .map(this::hotelToHotelResponse)
                        .collect(Collectors.toList())
        );

        return hotelListResponse;
    }
}
