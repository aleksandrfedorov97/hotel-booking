package com.example.hotelbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    private Long id;
    private String name;
    private String description;
    private String number;
    private Long price;
    private Integer capacity;
}
