package com.example.hotelbooking.web.dto.user;

import com.example.hotelbooking.entity.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private RoleType role;
}
