package com.suman.spring_boilerplate.spring_boilerplate.application.user.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.suman.spring_boilerplate.spring_boilerplate.domain.entity.User;
import lombok.Data;

@Data
public class UpdateUserRequestDto {
    @JsonAlias("first_name")
    private String firstName;
    @JsonAlias("last_name")
    private String lastName;
    @JsonAlias("email")
    private String email;
    @JsonAlias("phone")
    private String phone;

    public User MapToUserEntity(){
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .email(this.email)
                .phone(this.phone)
                .build();
    }
}
