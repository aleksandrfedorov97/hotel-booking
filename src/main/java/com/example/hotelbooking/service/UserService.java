package com.example.hotelbooking.service;

import com.example.hotelbooking.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User create(User user);
    User update(User user);
    void deleteById(Long id);
}
