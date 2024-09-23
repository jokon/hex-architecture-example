package com.jarecki.shopdemo.domain.core;

import com.jarecki.shopdemo.domain.model.Cart;
import com.jarecki.shopdemo.domain.model.Order;
import com.jarecki.shopdemo.domain.model.OrderItem;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.ports.out.OrderRepository;
import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;

import java.util.List;
import java.util.UUID;

public class DomainOrderFacade implements OrderFacade {

    private final OrderRepository orderRepository;

    public DomainOrderFacade(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(User user, Cart cart) {
        List<OrderItem> orderItems = cart.getItems().stream()
                .map(cartItem -> new OrderItem(UUID.randomUUID(), cartItem.getProduct(), cartItem.quantity(),
                        cartItem.getUnitPrice()))
                .toList();
        Order order = new Order(UUID.randomUUID(), user, orderItems);

        orderRepository.save(new OrderDb(order.getId()));
        return order.getId();
    }

    public Order getOrder(UUID id) {
        return orderRepository.findById(id).map(order -> new Order(order.getId(), null, null)).orElseThrow(RuntimeException::new);
    }
}
