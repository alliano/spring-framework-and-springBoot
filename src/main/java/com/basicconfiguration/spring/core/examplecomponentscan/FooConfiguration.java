package com.basicconfiguration.spring.core.examplecomponentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.Foo;

@Configuration
public class FooConfiguration {
   @Bean(value = "Foo")
   public Foo bar(){
      return new Foo();
   }
}
