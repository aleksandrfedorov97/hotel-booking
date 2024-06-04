package com.example.hotelbooking.service.impl;

import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.exception.UserAlreadyExistsException;
import com.example.hotelbooking.exception.UserNotFoundException;
import com.example.hotelbooking.repository.UserRepository;
import com.example.hotelbooking.service.UserService;
import com.example.hotelbooking.web.dto.user.UserUpsertRequest;
import com.example.hotelbooking.web.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByUsername(email);
    }

    public User create(UserUpsertRequest request) {
        User user = userMapper.userUpsertRequestToUser(request);

        if (existsByUsername(user.getUsername())) {
            throw new UserAlreadyExistsException("username", user.getUsername());
        }

        if (existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("email", user.getEmail());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User update(Long id, UserUpsertRequest request) {
        User user = userMapper.userUpsertRequestToUser(id, request);

        User existedUser = findById(user.getId());

        if (StringUtils.hasText(user.getUsername())) {
            if (existsByUsername(user.getUsername())) {
                throw new UserAlreadyExistsException("username", user.getUsername());
            }

            existedUser.setUsername(user.getUsername());
        }

        if (StringUtils.hasText(user.getPassword())) {
            existedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        if (StringUtils.hasText(user.getEmail())) {
            if (existsByEmail(user.getEmail())) {
                throw new UserAlreadyExistsException("email", user.getEmail());
            }

            existedUser.setEmail(user.getEmail());
        }

        if (user.getRole() != null) {
            existedUser.setRole(user.getRole());
        }

        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
