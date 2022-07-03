package com.basicconfiguration.spring.core.examplecomponentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.Bar;

@Configuration
public class BarConfiguration {
   
   @Bean(value = "bar")
   public Bar bar(){
      return new Bar();
   }
}
