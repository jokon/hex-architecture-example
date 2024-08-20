package com.jarecki.shopdemo.infrastructure.config;

import com.jarecki.shopdemo.ShopDemoApplication;
import com.jarecki.shopdemo.domain.repository.OrderRepository;
import com.jarecki.shopdemo.domain.repository.UserRepository;
import com.jarecki.shopdemo.domain.service.DomainOrderService;
import com.jarecki.shopdemo.domain.service.DomainUserService;
import com.jarecki.shopdemo.domain.service.OrderService;
import com.jarecki.shopdemo.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ShopDemoApplication.class)
public class ShopConfiguration {

    @Bean
    OrderService orderService(OrderRepository repository) {
        return new DomainOrderService(repository);
    }

    @Bean
    UserService userService(UserRepository repository) {
        return new DomainUserService(repository);
    }
}
