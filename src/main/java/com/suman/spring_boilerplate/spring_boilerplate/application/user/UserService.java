package com.suman.spring_boilerplate.spring_boilerplate.application.user;

import com.suman.spring_boilerplate.spring_boilerplate.domain.entity.User;

import java.util.UUID;

public interface UserService {
    User createUser(User user);
    User getUserByID(UUID id);
    User updateUserById(UUID id,User user);
}
