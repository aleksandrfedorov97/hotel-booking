package com.example.hotelbooking.web.controller;

import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.service.UserService;
import com.example.hotelbooking.web.dto.user.UserListResponse;
import com.example.hotelbooking.web.dto.user.UserResponse;
import com.example.hotelbooking.web.dto.user.UserUpsertRequest;
import com.example.hotelbooking.web.mapper.UserMapper;
import jakarta.validation.Valid;
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
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll() {
        return ResponseEntity.ok(
                userMapper.userListToUserListResponse(userService.findAll())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                userMapper.userToUserResponse(userService.findById(id))
        );
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserUpsertRequest request) {
        User createdUser = userService.create(userMapper.userUpsertRequestToUser(request));

        return ResponseEntity.ok(
                userMapper.userToUserResponse(createdUser)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody @Valid UserUpsertRequest request) {
        User updatedUser = userService.update(userMapper.userUpsertRequestToUser(id, request));

        return ResponseEntity.ok(
                userMapper.userToUserResponse(updatedUser)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
