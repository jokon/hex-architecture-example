package com.jarecki.shopdemo.infrastructure.config;

import com.jarecki.shopdemo.ShopDemoApplication;
import com.jarecki.shopdemo.domain.model.command.FindUserByIdCommand;
import com.jarecki.shopdemo.domain.ports.in.CreateUserUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByIdUseCase;
import com.jarecki.shopdemo.domain.ports.in.FindUserByNameUseCase;
import com.jarecki.shopdemo.domain.ports.in.GetAllUsersUseCase;
import com.jarecki.shopdemo.domain.ports.out.OrderRepository;
import com.jarecki.shopdemo.domain.ports.out.UserRepository;
import com.jarecki.shopdemo.domain.core.DomainOrderFacade;
import com.jarecki.shopdemo.domain.core.DomainUserFacade;
import com.jarecki.shopdemo.domain.core.OrderFacade;
import com.jarecki.shopdemo.domain.core.UserFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ShopDemoApplication.class)
public class ShopConfiguration {

    @Bean
    OrderFacade orderService(OrderRepository repository) {
        return new DomainOrderFacade(repository);
    }

    @Bean
    CreateUserUseCase createUserUseCase(UserRepository repository) {
        return new DomainUserFacade(repository);
    }

    @Bean
    DomainUserFacade userFacade(UserRepository repository) {
        return new DomainUserFacade(repository);
    }

    @Bean
    FindUserByNameUseCase findUserByNameUseCase(UserRepository repository) {
        return userFacade(repository);
    }

    @Bean
    FindUserByIdUseCase findUserByIdUseCase(UserRepository repository) {
        return userFacade(repository);
    }

    @Bean
    GetAllUsersUseCase getAllUsersUseCase(UserRepository repository) {
        return userFacade(repository);
    }


}
