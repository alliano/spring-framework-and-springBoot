package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class BeanNameConfiguration {

   /*
    * secara default nama bean di ambil dari nama method 
    * tetapi kadang kita tidak ingin menggunakan nama method untuk menjadi nama 
    * bean 
    * jikalau project sudah sangat besar kadang kita bisa memiliki nama method bean
    * yang sama walaupun isinya berbeda dan di spring framework itu
    * nama bean tidakboleh sama 
    * nama bean harus lah Unique
    * untuk membuat nama bean kita bisa menambahkan parameter name="" atau value=""
    * didalam parameter annotasi @bean 
    * contoh : @bean(name = "ex1")
    */
   @Primary
   @Bean(value = "foo_first")
   public Foo foo1(){
      return new Foo();
   }
   @Bean(value = "foo_second")
   public Foo foo2(){
      return new Foo();
   }
}
