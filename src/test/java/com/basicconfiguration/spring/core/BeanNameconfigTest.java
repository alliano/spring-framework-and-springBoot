package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Foo;

public class BeanNameconfigTest {
   
   public ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
   }
   @Test
   void testName(){
      Foo foo1 = this.context.getBean("foo_first",Foo.class );
      Foo foo2 = this.context.getBean("foo_second",Foo.class );
      Foo fooFirst = this.context.getBean(Foo.class );

      Assertions.assertSame(foo1, fooFirst);
      Assertions.assertNotSame(foo1, foo2);;
      Assertions.assertNotSame(fooFirst, foo2);;
   }
}
