package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.web.dto.user.UserUpsertRequest;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User create(UserUpsertRequest request);
    User update(Long id, UserUpsertRequest request);
    void deleteById(Long id);
}
