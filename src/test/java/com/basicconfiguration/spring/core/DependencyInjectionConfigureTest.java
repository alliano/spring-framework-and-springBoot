package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class DependencyInjectionConfigureTest {
   
   private ApplicationContext context;

   @BeforeEach
   void setUp(){
      this.context = new AnnotationConfigApplicationContext(DependencyInjectionConfigure.class);
   }
   
   // untuk dependency injection secara otomatis kita bila lakukan seperti ini 
   @Test
   void tesDependen(){
      // kita tidak perlu menambahkan keyword new lagi unutuk inisiasi Foo dan Bar
      Foo foo = this.context.getBean("foo",Foo.class);
      Bar bar = this.context.getBean("bar",Bar.class);
      FooBar fooBar = this.context.getBean(FooBar.class);

      Assertions.assertSame(foo, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
