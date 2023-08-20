package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.example.service.UserService;
import com.basicconfiguration.spring.core.example.serviceImpl.UserServiceImpl;

public class InheritanceTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testInheritance() {
        UserServiceImpl userServiceImpl = this.context.getBean(UserServiceImpl.class);
        UserService userService = this.context.getBean(UserService.class);
        Assertions.assertNotNull(userService);
        Assertions.assertNotNull(userServiceImpl);
        Assertions.assertSame(userServiceImpl, userService);
    }
}