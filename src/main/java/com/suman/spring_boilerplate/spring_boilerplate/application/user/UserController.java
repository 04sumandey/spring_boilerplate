package com.suman.spring_boilerplate.spring_boilerplate.application.user;


import com.suman.spring_boilerplate.spring_boilerplate.application.user.dto.*;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.Util;
import com.suman.spring_boilerplate.spring_boilerplate.common.responseUtil.dto.Response;

import com.suman.spring_boilerplate.spring_boilerplate.domain.entity.User;
import lombok.RequiredArgsConstructor;

import org.hibernate.sql.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final Util util;

    @PostMapping("/user")
    public ResponseEntity<Response<CreateUserResponseDto>> createUser(@RequestBody CreateUserRequestDto dto) {
        try {
            User user = User.builder()
                    .firstName(dto.getFirstName())
                    .lastName(dto.getLastName())
                    .email(dto.getEmail())
                    .phone(dto.getPhone())
                    .build();

            User createdUser = userService.createUser(user);
            CreateUserResponseDto responseDto = CreateUserResponseDto.builder()
                    .id(createdUser.getId())
                    .firstName(createdUser.getFirstName())
                    .lastName(createdUser.getLastName())
                    .email(createdUser.getEmail())
                    .build();
            return util.successBuilder(responseDto).toEntity();
        } catch (Exception e) {
            return util.<CreateUserResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Response<GetUserResponseDto>> getUser(@PathVariable UUID id) {
        try {
            User user = userService.getUserByID(id);
            GetUserResponseDto responseDto = GetUserResponseDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .email(user.getEmail())
                    .phone(user.getPhone())
                    .build();
            return util.successBuilder(responseDto).toEntity();
        } catch (Exception e) {
            return util.<GetUserResponseDto>FailureBuilder(e).toEntity();
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Response<UpdateUserResponseDto>> updateUser(
            @PathVariable UUID id, @RequestBody UpdateUserRequestDto updateDto) {
        try {
            User userToBeUpdated =updateDto.MapToUserEntity();
            User updatedUser = userService.updateUserById(id, userToBeUpdated);
            UpdateUserResponseDto responseDto = UpdateUserResponseDto.builder()
                    .id(updatedUser.getId())
                    .firstName(updatedUser.getFirstName())
                    .lastName(updatedUser.getLastName())
                    .email(updatedUser.getEmail())
                    .phone(updatedUser.getPhone())
                    .build();
            return util.successBuilder(responseDto).toEntity();

        } catch (Exception e) {
            return util.<UpdateUserResponseDto>FailureBuilder(e).toEntity();
        }


    }
}
