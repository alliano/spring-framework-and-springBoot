package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.basicconfiguration.spring.core.service.AuthService;

public class AwareTest {
   
   @Configuration
   @Import(value = {AuthService.class})
   public static class AwareConfiguration {}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
   }

   @Test
   void awareTest(){
      AuthService authService = this.context.getBean(AuthService.class);
      System.out.println(authService.getApplicationContext());
      System.out.println(authService.getBeanName());

      Assertions.assertSame(this.context, authService.getApplicationContext());
      Assertions.assertNotNull(authService);
      Assertions.assertEquals("com.basicconfiguration.spring.core.service.AuthService", authService.getBeanName());
   }
}
