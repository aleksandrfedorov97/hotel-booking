package com.example.hotelbooking.web.controller;

import com.example.hotelbooking.entity.Hotel;
import com.example.hotelbooking.service.HotelService;
import com.example.hotelbooking.web.dto.hotel.HotelResponse;
import com.example.hotelbooking.web.dto.hotel.HotelUpsertRequest;
import com.example.hotelbooking.web.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                hotelMapper.hotelToHotelResponse(hotelService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<HotelResponse> create(@RequestBody HotelUpsertRequest request) {
        Hotel createdHotel = hotelService.create(request);

        return ResponseEntity.ok(
                hotelMapper.hotelToHotelResponse(createdHotel)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelResponse> update(@PathVariable Long id, @RequestBody HotelUpsertRequest request) {
        Hotel updatedHotel = hotelService.update(id, request);

        return ResponseEntity.ok(
                hotelMapper.hotelToHotelResponse(updatedHotel)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        hotelService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
