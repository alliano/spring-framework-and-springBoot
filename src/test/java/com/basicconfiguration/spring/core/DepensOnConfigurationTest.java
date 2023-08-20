package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;

public class DepensOnConfigurationTest {
   private ApplicationContext context;
   
   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(DependsOnConfiguration.class);
   }

   @Test
   void testDepenOn(){
      Bar bar = context.getBean("barDependsOn",Bar.class);
      Assertions.assertNotNull(bar);
   }
}
