package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationTest {

   /**
    * ktia bisa meng test application context dengan cara polimophisem 
    * class AnnotationConfigApplicationContext 
    * 
    * 
    */
   @Test
   void testApplicationContext(){
      ApplicationContext context = new AnnotationConfigApplicationContext(HelloWolrdConfiguration.class);

      Assertions.assertNotNull(context);
   }
   
}
