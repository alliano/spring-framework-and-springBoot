package com.basicconfiguration.spring.core.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import com.basicconfiguration.spring.core.aware.IdAware;
import lombok.extern.slf4j.Slf4j;

/**
 * ORDERED
 * sat kita membuat beanPostProcessor kita bisa membaut lebih dari satu 
 * kadang ada kasus saat membaut BeanPostProcessor, misalnya kita ingin membaut dengan berururtan
 * Sayang nya secara devault, Spring tidak menjamin urutan eksekusinya 
 * agar kita bisa menetukan urutanya kita bisa menggunakan interface Ordered
 * 
 * class yang berkaitan PrefixIdGeberatorPostProcessor -> IdAware -> OrderedTest
 */


@Component @Slf4j
public class PrefixIdGeberatorPostProcessor implements BeanPostProcessor, Ordered {

   @Override
   public int getOrder() {
      return 2;
   }
   
   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      log.info("Prefix Id Generator Processor for Bean {} ", beanName);
      if (bean instanceof IdAware){
         log.info("Prefix set Id Generator Processor for Bean {} ", beanName);
         IdAware idAware =  (IdAware) bean;
         idAware.setId("Second-" + idAware.getId());
      }
      return bean;
   }
}
