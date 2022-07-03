package com.basicconfiguration.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicA;
import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicB;
import com.basicconfiguration.spring.core.helper.cilcularDependency.CyclicC;

@Configuration
public class CyclicConfiguration {

   @Bean(value = "cyclicA")
   public CyclicA cyclicA(CyclicB cyclicB){
      return new CyclicA(cyclicB);
   }

   @Bean(value = "cyclicB")
   public CyclicB cyclicB(CyclicC cyclicC){
      return new CyclicB(cyclicC);
   }

   @Bean(value = "cyclicC")
   public CyclicC cyclicC(CyclicA cyclicA){
      return new CyclicC(cyclicA);
   }
   
}
