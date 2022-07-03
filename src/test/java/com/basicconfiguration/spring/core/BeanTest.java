package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class BeanTest {

   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
   }
   
   @Test
   void TestBean(){
      Assertions.assertNotNull(context);  
   }

   @Test
   void getBean(){
      /**
       * saat kita memanggil bean nya 2x ini kan membuat object hanya 1x
       * jadi sebelum Foo di panggil itu udah di buat terlebihdahulu 
       * dan saat kita panggil maka akan mereturn object yang sama dan tidak meng create object baru
       */
      Foo foo1 = context.getBean(Foo.class);
      Foo foo2 = context.getBean(Foo.class);

      /** 
       * untuk membuktikan bahawa ini sama kita bisa cek 
       */
      Assertions.assertSame(foo1, foo2);

   }
}
