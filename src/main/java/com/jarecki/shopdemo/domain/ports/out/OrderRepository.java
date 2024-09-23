package com.jarecki.shopdemo.domain.ports.out;

import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Optional<OrderDb> findById(UUID id);
    void save(OrderDb order);
}
