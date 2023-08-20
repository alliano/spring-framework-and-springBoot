package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LazyBeanConfiguration {

   // method ini akan membuat bean Foo saat bean tersebut dibutuhkan atau di akses
   @Lazy
   @DependsOn("bar_")
   @Bean(value = "fooLazy")
   public Foo foo(){
      log.info("====creating fooLazy====");
      return new Foo();
   }

   @Bean(value = "bar_")
   public Bar bar(){
      log.info("====creating bar_====");
      return new Bar();
   }
}
