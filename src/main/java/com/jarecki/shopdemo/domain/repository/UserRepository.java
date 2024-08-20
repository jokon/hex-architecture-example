package com.jarecki.shopdemo.domain.repository;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.infrastructure.adapter.out.UserDb;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    List<UserDb> findByName(String name);
    Optional<UserDb> findById(UUID name);
    void save(User user);
    List<UserDb> getAll();
}
