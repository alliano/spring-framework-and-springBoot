package com.basicconfiguration.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class FooConfiguration {

   @Bean
   public Foo foo1(){
      return new Foo();
   }
   @Bean
   public Foo foo2(){
      return new Foo();
   }
   @Bean
   public Foo foo3(){
      return new Foo();
   }
}
