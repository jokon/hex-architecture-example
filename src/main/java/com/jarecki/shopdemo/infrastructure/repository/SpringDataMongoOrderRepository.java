package com.jarecki.shopdemo.infrastructure.repository;

import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataMongoOrderRepository extends MongoRepository<OrderDb, UUID> {

}
