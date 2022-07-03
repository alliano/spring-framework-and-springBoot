package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Bar;

public class LazyBeanConfigurationTest {
   

   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
   }

   @Test
   void tetLazyBean(){
      Bar bar = this.context.getBean("barLazy",Bar.class);
      Assertions.assertNotNull(bar);

      /**
       * jika kita tidak memanggil bean fooLazy maka bean fooLazy tidak akan di buat
       * karna bean fooLazy telah di annotasi sebagai @Lazy 
       * jadi bean tersebut akan di buat kalaui bean tersebut di butuhkan
       */
      
      // Foo foo = this.context.getBean("fooLazy",Foo.class);
      // Assertions.assertNotNull(foo);
   }
}
