package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.BookingDetails;
import com.example.hotelbooking.web.dto.bookingdetails.BookingDetailsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookingDetailsMapper {
    @Mappings({
            @Mapping(source = "room.id", target = "roomId"),
    })
    BookingDetailsResponse bookingDetailsToBookingDetailsResponse(BookingDetails bookingDetails);
}
