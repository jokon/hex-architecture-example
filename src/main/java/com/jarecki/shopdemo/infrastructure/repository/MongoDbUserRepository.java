package com.jarecki.shopdemo.infrastructure.repository;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.UserRepository;
import com.jarecki.shopdemo.infrastructure.adapter.out.UserDb;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDbUserRepository implements UserRepository {
    private final SpringDataMongoUserRepository userRepository;

    public MongoDbUserRepository(SpringDataMongoUserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<UserDb> findById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(new UserDb(user.getId(), user.getName()));
    }

}
