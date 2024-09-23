package com.jarecki.shopdemo.domain.core;

import com.jarecki.shopdemo.domain.model.Cart;
import com.jarecki.shopdemo.domain.model.User;

import java.util.UUID;

public interface OrderFacade {
        UUID createOrder(User user, Cart cart);
}
