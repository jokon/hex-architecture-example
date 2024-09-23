package com.jarecki.shopdemo.domain.core;

import com.jarecki.shopdemo.domain.model.Cart;
import com.jarecki.shopdemo.domain.model.CartItem;
import com.jarecki.shopdemo.domain.model.Product;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.ports.out.OrderRepository;
import com.jarecki.shopdemo.infrastructure.adapter.out.OrderDb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DomainOrderServiceTest {

    private DomainOrderFacade domainOrderService;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        domainOrderService = new DomainOrderFacade(orderRepository);
    }

    @Test
    void createOrder() {
        //given
        String userName = "John Doe";
        String productName = "ProductName";
        BigDecimal productPrice = new BigDecimal("10.23");
        User user = new User(UUID.randomUUID(), "John Doe");
        Product product = new Product(UUID.randomUUID(), productName, productPrice, 100);
        CartItem cartItem = new CartItem(UUID.randomUUID(), product, product.getPrice(), 2);
        Cart cart = new Cart(UUID.randomUUID(), List.of(cartItem), user);

        //when
        domainOrderService.createOrder(user, cart);

        //then
        ArgumentCaptor<OrderDb> capturedOrder = ArgumentCaptor.forClass(OrderDb.class);
        verify(orderRepository, times(1)).save(capturedOrder.capture());
        OrderDb orderToVerify = capturedOrder.getValue();
//        assertEquals(user, orderToVerify.getUser());
//        assertEquals(1, orderToVerify.getItems().size());
//        OrderItem orderItem = orderToVerify.getItems().stream().findFirst().get();
//        assertEquals(productPrice.multiply(new BigDecimal(2)), orderItem.getPrice());
//        assertEquals(productName, orderItem.getProduct().getName());
//        assertEquals(productPrice, orderItem.getUnitPrice());
    }
}