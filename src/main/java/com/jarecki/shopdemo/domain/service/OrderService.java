package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.Basket;
import com.jarecki.shopdemo.domain.model.OrderItem;
import com.jarecki.shopdemo.domain.model.User;

import java.util.Collection;
import java.util.UUID;

public interface OrderService {
        UUID createOrder(User user, Basket basket);
}
