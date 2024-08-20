package com.jarecki.shopdemo.infrastructure.repository;

import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.infrastructure.adapter.out.UserDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<UserDb, UUID> {

//    @Query("{ 'name' : ?0 }")
    Optional<User> findByName(String name);

}
