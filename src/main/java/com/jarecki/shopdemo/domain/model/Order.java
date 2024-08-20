package com.jarecki.shopdemo.domain.model;

import lombok.Getter;

import java.util.Collection;
import java.util.UUID;

@Getter
public class Order {

    public Order(UUID id, User user, Collection<OrderItem> items) {
        this.id = id;
        this.user = user;
        this.items = items;
    }

    private final UUID id;
    private final User user;
    private final Collection<OrderItem> items;

}
