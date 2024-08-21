package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.Cart;
import com.jarecki.shopdemo.domain.model.User;

import java.util.UUID;

public interface OrderService {
        UUID createOrder(User user, Cart cart);
}
