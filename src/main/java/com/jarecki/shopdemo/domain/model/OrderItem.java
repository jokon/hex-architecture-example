package com.jarecki.shopdemo.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OrderItem {

    public OrderItem(UUID id, Product product, int quantity, BigDecimal unitPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    private final UUID id;
    private final Product product;
    private final int quantity;
    private final BigDecimal unitPrice;

    public BigDecimal getPrice() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }
}
