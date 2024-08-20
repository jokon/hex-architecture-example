package com.jarecki.shopdemo.domain.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int quantity;
    private String description;

    public Product(UUID id, String name, BigDecimal price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product withDescription(String description) {
        this.description = description;
        return this;
    }

}
