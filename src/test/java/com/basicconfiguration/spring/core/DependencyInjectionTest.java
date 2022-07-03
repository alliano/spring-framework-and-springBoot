package com.basicconfiguration.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

/*
 * dependency injection adalah teknik dimna kita bisa mengotomasi proses pembuatan
 * object yang tergantungh pada object lain
 * dependencies akan secara otomatis di inject(di masukan) kedalam object yang 
 * membutuhkanya 
 * dan spring framework disebut dengan framework IOC(inversion of control) yang cara kerjanya menggunakan
 * dependency injection
 * sebenarnya tampa dependency injection kita ttp bisa membuat suatu software
 * tetapi ketika relasi antar dependency sangat komplex maka kita akan 
 * kesusahan jika di lakukan secara manual
 * dan karna itu menggunkan DI seperti spring sangat lah membantu
 */
public class DependencyInjectionTest{

   /**
    * ini adalah contoh dependency injection secara manual
    */

   @Test
   void tesDependency(){
      Foo foo = new Foo();
      Bar bar = new Bar();

      FooBar fooBar = new FooBar(foo,bar);

      Assertions.assertSame(foo, fooBar.getFoo());
      Assertions.assertSame(bar, fooBar.getBar());

   }
}
