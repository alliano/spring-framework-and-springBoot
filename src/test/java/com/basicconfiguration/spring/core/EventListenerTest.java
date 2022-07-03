package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.basicconfiguration.spring.core.listerner.LogginSuccessListener;
import com.basicconfiguration.spring.core.listerner.UserListener;
import com.basicconfiguration.spring.core.service.UserService;

public class EventListenerTest {
   
   @Configuration
   @Import(value = {UserService.class,LogginSuccessListener.class,UserListener.class})
   public static class EventListenerConfiguration{}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void eventListenerTest(){
      UserService userService = this.context.getBean(UserService.class);
      userService.login("alliano", "hagoromo");
      userService.login("jincuriki", "hasirama");
      userService.login("otsusuki hamura", "konoha");
   }
}
