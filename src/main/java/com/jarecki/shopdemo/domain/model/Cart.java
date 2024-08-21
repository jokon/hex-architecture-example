package com.jarecki.shopdemo.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.UUID;

@Getter
public class Cart {
    private UUID id;
    private Collection<CartItem> items;
    private User user;

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Cart(UUID id, Collection<CartItem> items, User user) {
        this.id = id;
        this.items = items;
        this.user = user;
    }

}
