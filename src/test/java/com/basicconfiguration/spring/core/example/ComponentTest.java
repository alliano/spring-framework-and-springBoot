package com.basicconfiguration.spring.core.example;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(UserService.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testUserService() throws NoSuchMethodException, SecurityException {
        UserService userService = this.context.getBean("userService_", UserService.class);
        assertNotNull(userService);
    }
}
