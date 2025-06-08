package com.suman.spring_boilerplate.spring_boilerplate.repository;

import com.suman.spring_boilerplate.spring_boilerplate.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
