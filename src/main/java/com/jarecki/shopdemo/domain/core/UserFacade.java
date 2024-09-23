package com.jarecki.shopdemo.domain.core;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.ports.in.CreateUserUseCase;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserFacade {

    List<User> findUserByName(String name);
    Optional<User> findUserById(UUID id);
    List<User> getAll();
}
