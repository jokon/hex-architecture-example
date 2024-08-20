package com.jarecki.shopdemo.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

@Getter
public class Basket {
    private UUID id;
    private Collection<BasketItem> items;
    private User user;

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(BasketItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Basket(UUID id, Collection<BasketItem> items, User user) {
        this.id = id;
        this.items = items;
        this.user = user;
    }

}
