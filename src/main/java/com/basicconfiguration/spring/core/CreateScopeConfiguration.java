package com.basicconfiguration.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   private Logger logger = LoggerFactory.getLogger(CreateScopeConfiguration.class);

   /**
    * register scope
    * @return
    */
   @Bean(value = "configurer")
   public CustomScopeConfigurer configurer(){
      CustomScopeConfigurer configurer = new CustomScopeConfigurer();
      configurer.addScope("doubleton", new DoubletonScope());
      return configurer;
   }
   @Scope(value = "doubleton")
   @Bean(value = "foo")
   public Foo foo(){
      logger.info("==>foo has created by scope doubleton<==");
      return new Foo();
   }

}
