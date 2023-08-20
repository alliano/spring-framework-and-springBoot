package com.basicconfiguration.spring.core.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.AwareConfiguration;
import com.basicconfiguration.spring.core.service.AuthService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AwareTest {
    
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setUp() {
        this.context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        this.context.registerShutdownHook();
    }

    @Test
    public void testAuthService() {
        AuthService authService = this.context.getBean(AuthService.class);
        Assertions.assertEquals(AuthService.class.getName(), authService.getBeanName());
        log.info(authService.getBeanName());
        Assertions.assertNotNull(authService.getEnvironment());
        Assertions.assertSame(this.context, authService.getApplicationContext());        
    }
}
