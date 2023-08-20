package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {

   /**
    * ktia bisa meng test application context dengan cara polimophisem 
    * class AnnotationConfigApplicationContext
    */
   @Test
   void testApplicationContext(){
      /**
       * membuat ApplicationContext, dengan membuat ApplicationContext kita dapt berintraksi dengan spring IOC
       * 
       * AnnotationConfigApplicationContext() => digunakan untuk membuat ApplicationContext dengan 
       * kofigurasi annotation based
       */
      ApplicationContext context = new AnnotationConfigApplicationContext(HelloWolrdConfiguration.class);
      Assertions.assertNotNull(context);
   }
}