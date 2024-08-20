package com.jarecki.shopdemo.domain.repository;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.infrastructure.adapter.out.UserDb;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findByName(String name);
    Optional<UserDb> findById(UUID name);

    void save(User user);
}
