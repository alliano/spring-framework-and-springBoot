package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class PrimaryBeanConfiguration{

   /**
    * untuk mengatasi duplicate Bean sebenarnya kita bisa mengatasinya
    * dengan menambahkan annotasi @Primary di salah satu @bean 
    * ini artinya nanti jikalau bean itu di panggil tampa memanggil namanya jga 
    * maka @bean yang di anotasi sebagai @Primary akan di panggil 
    * jadi spring nya tidak bingung
    * Contoh :
    * @return
    */

   @Bean @Primary
   public Foo foo1(){
      return new Foo();
   }

   @Bean
   public Foo foo2(){
      return new Foo();
   }
}