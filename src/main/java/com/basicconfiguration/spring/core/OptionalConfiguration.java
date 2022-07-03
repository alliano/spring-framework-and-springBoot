package com.basicconfiguration.spring.core;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.FooBar;

@Configuration
public class OptionalConfiguration {

   /**
    * Optional dependency 
    * secara default semua dependency itu wajib
    * Artinya jikalau spring tidak bisa meenemukan bean yang dibutuhkan pada saat DI, maka secara 
    * otomatis akan terjadi Error
    * namun jika kita ingin membuat sebuah dependency menjadi Optional, artinya tidak wajib
    * kita biasa wrap dependency tersebut dengan menggunakan java.util.Optional<T> 
    * secara otomatis jika bean yang dibuthkan tidak ada maka tidak akan terjadi error
    * kita bisa menggunkaan Optional<T> pada @Bean(method parameter) atau pun @Component
    * (constructor parameter,setter method parameter, field)  
    * @return
    */

   @Bean(value = "foo")
   public Foo foo(){
      return new Foo();
   }

   @Bean(value = "fooBar")
   public FooBar fooBar(Optional<Foo> foo,Optional<Bar> bar){
      return new FooBar(foo.orElse(null),bar.orElse(null));
   }
   
}
