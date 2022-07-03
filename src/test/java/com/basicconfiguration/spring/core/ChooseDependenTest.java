package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class ChooseDependenTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(ChooseDependen.class);
   }

   @Test
   void chooseDependen(){
      Foo fooSecond = this.context.getBean("fooSecond",Foo.class);
      Bar bar = this.context.getBean(Bar.class);
      FooBar fooBar = context.getBean("fooBar",FooBar.class);

      Assertions.assertSame(fooSecond, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
