package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

public class DependencyInjectionTest{

   /**
    * ini adalah contoh dependency injection secara manual
    */

   @Test
   void testNoDependencyInjection(){
      Foo foo = new Foo();
      Bar bar = new Bar();

      FooBar fooBar = new FooBar(foo,bar);

      Assertions.assertSame(foo, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());
   }
}
