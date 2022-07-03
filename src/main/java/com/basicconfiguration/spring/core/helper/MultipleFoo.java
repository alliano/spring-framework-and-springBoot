package com.basicconfiguration.spring.core.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * selain kita menggunakan object Optional<T> kita juga bisa menggunakan ObjectProvider<T> 
 * yang membedakan pada ObjectProvider<T> adalah, jika ternyata beanya lebih dari satu,
 * ObjectProvider<T> bisa digunakan untuk mengambil semua bean tersebut
 * 
 * class yang berangkutan Fooconfiguration.java MultipleFoo.java ComponentConfigurationTest.java
 */

@Component
public class MultipleFoo {

   private List<Foo> foo;

   public MultipleFoo(ObjectProvider<Foo> foo){
      this.foo = foo.stream().collect(Collectors.toList());
   }

   public void setFoo(List<Foo> foo) {
      this.foo = foo;
   }
   public List<Foo> getFoo() {
      return foo;
   }
}