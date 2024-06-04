package com.example.hotelbooking.web.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserListResponse {
    private List<UserResponse> users;
}
