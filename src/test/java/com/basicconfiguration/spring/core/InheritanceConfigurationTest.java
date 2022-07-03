package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.service.MerchentService;
import com.basicconfiguration.spring.core.service.MerchentServiceImpl;

public class InheritanceConfigurationTest {
   ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testInheritance(){
      MerchentService merchentService = this.context.getBean(MerchentService.class);
      MerchentServiceImpl merchentServiceImpl = this.context.getBean(MerchentServiceImpl.class);

      Assertions.assertSame(merchentService, merchentServiceImpl);
   }
}
