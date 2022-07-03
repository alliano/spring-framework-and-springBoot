package com.basicconfiguration.spring.core.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import com.basicconfiguration.spring.core.helper.Foo;

/**
 * BeanFactoryPostProcessor
 * 
 * Secara default mungkin kita tidak akan pernah sama sekali membuat Application Contex secara manual
 * namun kadang ada keadaan kita ingin memodifikasi secara internal ApplicationContex 
 * Spring merekomndasikan kita untuk membuat BeanFactoryPostProcessor
 * 
 * kita bisa menginplementasi interface BeaDefinitionRegistryPostProcessor
 * interface BeaDefinitionRegistryPostProcessor adalah anak turunan dari Bean dfinition Post Processor
 */


public class FooBeanPostProcessor implements BeanDefinitionRegistryPostProcessor {

   @Override
   public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {}

   @Override
   public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
      GenericBeanDefinition devinition = new GenericBeanDefinition();
      devinition.setScope("singleton");
      devinition.setBeanClass(Foo.class);
      
      registry.registerBeanDefinition("foo", devinition);
   }
   
}
