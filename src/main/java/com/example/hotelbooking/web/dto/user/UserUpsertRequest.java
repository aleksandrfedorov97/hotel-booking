package com.example.hotelbooking.web.dto.user;

import com.example.hotelbooking.entity.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserUpsertRequest {
    @NotBlank(message = "Username must not be blank.")
    private String username;
    @NotBlank(message = "Password must not be blank.")
    private String password;
    @NotBlank(message = "Email must not be blank.")
    @Email(message = "Not valid email.")
    private String email;
    @NotNull(message = "Role must not be blank.")
    private RoleType role;
}
