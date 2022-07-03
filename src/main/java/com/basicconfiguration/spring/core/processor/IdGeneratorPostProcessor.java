package com.basicconfiguration.spring.core.processor;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import com.basicconfiguration.spring.core.aware.IdAware;

/**BeanPostProcressor
 * 
 * BeanPostProcessor merupakan sebuah interface yang bisa kita gunakan untuk memidifikasi 
 * proses pembuatan Bean di ApplicationContex.
 * BeanPostProcessor mirip seperti middleware, yang di akses sebalum bean di initialized 
 * dan setelah bean di initialized.
 * karna sangat flexibel bahkan BeanPostProcessor bisa memodifikasi hasil object Bean
 * 
 * Misal kita akan membuat id uniq untuk bean 
 * yang mana kita akan membuat interface bernama IdAware yaang memiliki method setId(Strinf) 
 * dan Kita akan membaut class IdGeneratorPostProcessor yang meng implementasi interface BeanPostProcessor
 * dan IdGeneratorPostProcessor meng overide method postProcessAfterInitialization yang mna method
 * tersebut berfungssi untuk megecek Bean yanng meng implementasi IdAware kita akan setId(String)
 * nya menjadi UUID (Unique Id)
 * 
 * class yang berkaitan Idgenerator -> IdgeneratorPostProcessor -> BeanpostProcessorTest
 * 
 * 
 */

public class IdGeneratorPostProcessor implements BeanPostProcessor ,Ordered{
   
   @Override
   public int getOrder() {
      return 1;
   }


   private Logger logger = LoggerFactory.getLogger(IdGeneratorPostProcessor.class);
   @Override
   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      
      logger.info("Id generator processor for Bean {} ", beanName);
      if (bean instanceof IdAware){
         logger.info("set Id generator for Bean {} ", beanName);
         IdAware idAware = (IdAware) bean;
         idAware.setId(UUID.randomUUID().toString());
      }
      return bean;
   }
 
   
   
}
