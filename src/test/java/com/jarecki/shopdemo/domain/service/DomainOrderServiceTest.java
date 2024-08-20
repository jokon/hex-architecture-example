package com.jarecki.shopdemo.domain.service;

import com.jarecki.shopdemo.domain.model.Basket;
import com.jarecki.shopdemo.domain.model.BasketItem;
import com.jarecki.shopdemo.domain.model.Order;
import com.jarecki.shopdemo.domain.model.OrderItem;
import com.jarecki.shopdemo.domain.model.Product;
import com.jarecki.shopdemo.domain.model.User;
import com.jarecki.shopdemo.domain.repository.OrderRepository;
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

    private DomainOrderService domainOrderService;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        domainOrderService = new DomainOrderService(orderRepository);
    }

    @Test
    void createOrder() {
        //given
        String userName = "John Doe";
        String productName = "ProductName";
        BigDecimal productPrice = new BigDecimal("10.23");
        User user = new User(UUID.randomUUID(), "John Doe");
        Product product = new Product(UUID.randomUUID(), productName, productPrice, 100);
        BasketItem basketItem = new BasketItem(UUID.randomUUID(), product, product.getPrice(), 2);
        Basket basket = new Basket(UUID.randomUUID(), List.of(basketItem), user);

        //when
        domainOrderService.createOrder(user, basket);

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