package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class DomainUserService implements UserService {

    private final UserRepository userRepository;

    public DomainUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UUID createUser(String name) {
        UUID id = UUID.randomUUID();
        userRepository.save(new User(id, name));
        return id;
    }

    public Optional<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id).map(userDb -> new User(userDb.getId(), userDb.getName()));
    }
}
