package com.jarecki.shopdemo.infrastructure.repository;

import com.jarecki.shopdemo.domain.ports.out.OrderRepository;
import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class MongoDbOrderRepository implements OrderRepository {
    private final SpringDataMongoOrderRepository orderRepository;

    public MongoDbOrderRepository(SpringDataMongoOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<OrderDb> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(OrderDb order) {
        orderRepository.save(order);
    }
}
