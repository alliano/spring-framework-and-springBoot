package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.basicconfiguration.spring.core.helper.Car;
import com.basicconfiguration.spring.core.processor.IdGeneratorPostProcessor;
import com.basicconfiguration.spring.core.processor.PrefixIdGeberatorPostProcessor;

public class OrderedBeanPostProcessor {
   
   @Configuration
   @Import(value = {Car.class,PrefixIdGeberatorPostProcessor.class,IdGeneratorPostProcessor.class})
   public static class OrderedConfiguration {}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(OrderedConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void orderedTest(){
      Car car = this.context.getBean(Car.class);

      Assertions.assertTrue(car.getId().startsWith("Second-"));
   }
}


