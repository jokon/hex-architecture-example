package com.jarecki.shopdemo.domain.repository;

import com.jarecki.shopdemo.domain.model.Order;
import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<OrderDb> findById(UUID id);
    void save(OrderDb order);
}
