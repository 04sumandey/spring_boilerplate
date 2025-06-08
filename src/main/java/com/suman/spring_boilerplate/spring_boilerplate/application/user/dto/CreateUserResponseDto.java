package com.suman.spring_boilerplate.spring_boilerplate.application.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;
@Data
@Builder
public class CreateUserResponseDto {
 private UUID id;
 @JsonAlias("first_name")
 private String firstName;
 @JsonAlias("last_name")
 private String lastName;
 @JsonAlias("phone")
 private String phone;
 @JsonAlias("email")
 private String email;

}
