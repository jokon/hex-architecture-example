package com.jarecki.shopdemo.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record CartItem(UUID id, Product product, BigDecimal unitPrice, int quantity) {

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public BigDecimal getPrice() {
        return unitPrice.multiply(new BigDecimal(quantity));
    }

    public Product getProduct() { return product; }

}
