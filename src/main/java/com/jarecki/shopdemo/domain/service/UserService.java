package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UUID createUser(String name);
    Optional<User> findUserByName(String name);
    Optional<User> findUserById(UUID id);
}
