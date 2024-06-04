package com.example.hotelbooking.repository;

import com.example.hotelbooking.entity.Room;
import com.example.hotelbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
