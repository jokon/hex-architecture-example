package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.Basket;
import com.jarecki.shopdemo.domain.model.Order;
import com.jarecki.shopdemo.domain.model.OrderItem;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.OrderRepository;
import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;

import java.util.List;
import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(User user, Basket basket) {
        List<OrderItem> orderItems = basket.getItems().stream()
                .map(basketItem -> new OrderItem(UUID.randomUUID(), basketItem.getProduct(), basketItem.quantity(),
                        basketItem.getUnitPrice()))
                .toList();
        Order order = new Order(UUID.randomUUID(), user, orderItems);

        orderRepository.save(new OrderDb(order.getId()));
        return order.getId();
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).map(order -> new Order(order.getId(), null, null)).orElseThrow(RuntimeException::new);
    }
}
