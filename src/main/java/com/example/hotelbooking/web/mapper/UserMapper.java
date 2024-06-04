package com.example.hotelbooking.web.mapper;

import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.web.dto.user.UserListResponse;
import com.example.hotelbooking.web.dto.user.UserResponse;
import com.example.hotelbooking.web.dto.user.UserUpsertRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponse userToUserResponse(User user);
    User userUpsertRequestToUser(UserUpsertRequest request);
    @Mapping(source = "userId", target = "id")
    User userUpsertRequestToUser(Long userId, UserUpsertRequest request);

    default UserListResponse userListToUserListResponse(List<User> users) {
        UserListResponse userListResponse = new UserListResponse();

        userListResponse.setUsers(
                users.stream()
                        .map(this::userToUserResponse)
                        .collect(Collectors.toList())
        );

        return userListResponse;
    }
}
