package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class OptionalDependencyTest {
   
   private ConfigurableApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
      this.context.registerShutdownHook();
   }

   @Test
   void OptionalTest(){
      Foo foo = this.context.getBean("foo",Foo.class);
      FooBar fooBar = this.context.getBean("fooBar",FooBar.class);

      /**
       * fooBar.getBar() akan mengembalikan niali null
       * karena kita tidak membuatkan bean dengan tidap Bar
       * */
      Assertions.assertNull(fooBar.getBar());
      Assertions.assertSame(foo, fooBar.getFoo());
   }
}
