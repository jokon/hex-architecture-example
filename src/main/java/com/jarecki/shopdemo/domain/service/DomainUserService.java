package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.UserRepository;

import java.util.List;
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

    public List<User> findUserByName(String name) {
        return userRepository.findByName(name).stream().map(userDb -> new User(userDb.getId(), userDb.getName())).toList();
    }

    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id).map(userDb -> new User(userDb.getId(), userDb.getName()));
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll().stream().map(userDb -> new User(userDb.getId(), userDb.getName())).toList();
    }
}
