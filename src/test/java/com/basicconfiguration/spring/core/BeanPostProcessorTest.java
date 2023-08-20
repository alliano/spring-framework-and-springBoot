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


public class BeanPostProcessorTest {
   
   /**
    * jka kita tidak meng import class IdGeneratorPostProcessor maka akan terjadi error karna
    * car.getId() tidak dapat menemukan String id yang dihasilkan dari class IdGeneratorPostProcessor
    */
   @Configuration
   @Import(value = {
      Car.class,
      IdGeneratorPostProcessor.class
   })
   public static class TestConfiguration { }

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(TestConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void testCar(){
      Car car = this.context.getBean(Car.class);

      System.out.println(car.getId());
      Assertions.assertNotNull(car.getId());
   }
}
