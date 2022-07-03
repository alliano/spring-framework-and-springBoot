package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CyclicConfigureationTest {
   
   @Test
   void tesCyclic(){
   
      /**
       * disini akan berhasil karna object ini terjadi error circular
       * yang man object tersebut salng terhubung sesama object lain dan hubungan tersebut membentuk lingkaran
       * cnth :
       * objA butuh objB objB butuh objC objC butuh objArm 
       */
      Assertions.assertThrows(Throwable.class, () -> {
         ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
      });
   }
}
