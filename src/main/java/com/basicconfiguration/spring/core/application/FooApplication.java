package com.basicconfiguration.spring.core.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;

@SpringBootApplication
public class FooApplication {
   
   // @Bean
   // public Foo foo(){
   //    return new Foo();
   // }

   @Bean
   Foo foo(Bar bar){
      return new Foo();
   }
   public static void main(String[] args) {
      ConfigurableApplicationContext context = SpringApplication.run(FooApplication.class, args);

      Foo foo = context.getBean(Foo.class);
      System.out.println(foo);
   }
}
