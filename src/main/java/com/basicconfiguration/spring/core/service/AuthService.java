package com.basicconfiguration.spring.core.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AuthService implements ApplicationContextAware, BeanNameAware, EnvironmentAware {
   /*Aware
    *
    * Spring memiliki interface yang bernama Aware 
    * Aware adalah super interface yang digunakan untuk semua Aware interface 
    * Aware ini diperuntukan untuk penanda agar Spring spring melakukan Injection object yang kita
    * butuhkan 
    * mirip seperti yang kita telah lakukan ketika kita membat IdAware menggunakan IdgeneratorBeanPostProcessor
    * Namuan ini kita tidak perlu lagi mambuat Bean PostProcessor secara manuaal 
    */

    /*
     * daftar Aware
     * **************************************************************** 
     * nama Aware               | keterangan
     ******************************************************************
     * ApplicationContexAware   |  untuk mendapatkan ApplicationContex
     * BeanFactoryAware         |  Untuk mendapatkan BeanFactory
     * BeanNameAware            |  Untuk mendapatkan nama Bean
     * ApplicatianPublisherAware|  Untuk mendapatkan Application Publisher
     * EnverionmentAware        |  Untuk mendapatkan Envrionment       
     * 
     */
   private String beanName;

   private ApplicationContext applicationContext;

   private Environment environment;
   
   @Override
   public void setBeanName(String name) {
      this.beanName = name;
   }

   public String getBeanName() {
      return beanName;
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext = applicationContext;
   }
   public ApplicationContext getApplicationContext() {
      return applicationContext;
   }

   @Override
   public void setEnvironment(Environment environment) {
      this.environment = environment;
   }

   public Environment getEnvironment() {
      return this.environment;
   }
}
