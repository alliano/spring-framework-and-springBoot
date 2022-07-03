package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.processor.FooBeanPostProcessor;

public class BanFactoryPostProcessorTest {
   
   @Configuration
   @Import(value = {FooBeanPostProcessor.class})
   public static class BeanFactoryPostProcessorConfiguration{}

   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   public void beanFactoryPostProcessorTest(){
      Foo foo = this.context.getBean("foo",Foo.class);
      Assertions.assertNotNull(foo);
   }
}
