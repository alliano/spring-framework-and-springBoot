package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import com.basicconfiguration.spring.core.helper.Bar;
import com.basicconfiguration.spring.core.helper.Foo;
import lombok.extern.slf4j.Slf4j;

@Configuration @Slf4j
public class DependsOnConfiguration {
    /**
     * bean ini kan dibuat setelah bean barDependensOn dibuat
     */
   @DependsOn({"barDependsOn"})
   @Bean(value = "fooDependsOn")
   public Foo foo(){    
     log.info("===========creating Foo============");
      return new Foo();
   }

   @Bean(value = "barDependsOn")
   public Bar bar(){
      log.info("========Creating bar=========");
      return new Bar();
   }
}
