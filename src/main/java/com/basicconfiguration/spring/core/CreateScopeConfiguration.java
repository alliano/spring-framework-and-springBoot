package com.basicconfiguration.spring.core;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.basicconfiguration.spring.core.helper.Foo;
import com.basicconfiguration.spring.core.helper.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CreateScopeConfiguration {
   
   // disini scope yang baru kita buat diregistrasikan
   @Bean(value = "customScopeConfigurer")
   public CustomScopeConfigurer configurer(){
      CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
      customScopeConfigurer.addScope("doubleton", new DoubletonScope());
      return customScopeConfigurer;
   }
   
   // scope digunakan
   @Scope(value = "doubleton")
   @Bean(value = "foo")
   public Foo foo(){
      log.info("==> FOO HAS CREATED WITH DOUBLETON SCOPE <==");
      return new Foo();
   }
}
