package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class ScopConfigurationTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
   }

   @Test
   void scopeTest(){
      Foo foo1 = this.context.getBean("fooScope",Foo.class);
      Foo foo2 = this.context.getBean("fooScope",Foo.class);
      Foo foo3 = this.context.getBean("fooScope",Foo.class);

      /**
       * ini akan mengembalikan 3 object yang berbeda karna kita telah mengubah
       * Scope nya menjadi prototype
       */
      Assertions.assertNotSame(foo1, foo2);
      Assertions.assertNotSame(foo1, foo3);
      Assertions.assertNotSame(foo2, foo3);
   }
}
