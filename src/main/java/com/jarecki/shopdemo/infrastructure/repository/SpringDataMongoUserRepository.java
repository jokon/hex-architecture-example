package com.jarecki.shopdemo.infrastructure.repository;

import com.jarecki.shopdemo.infrastructure.adapter.out.UserDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringDataMongoUserRepository extends MongoRepository<UserDb, UUID> {

//    @Query("{ 'name' : ?0 }")
    List<UserDb> findByName(String name);

}
