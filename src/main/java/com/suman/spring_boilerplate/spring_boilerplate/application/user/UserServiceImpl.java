package com.suman.spring_boilerplate.spring_boilerplate.application.user;

import com.suman.spring_boilerplate.spring_boilerplate.domain.entity.User;
import com.suman.spring_boilerplate.spring_boilerplate.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public User createUser(User user){
        return userRepository.save(user);
    }
}
