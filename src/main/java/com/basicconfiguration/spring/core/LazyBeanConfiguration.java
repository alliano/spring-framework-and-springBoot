package com.basicconfiguration.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   
   private Logger logger = LoggerFactory.getLogger(LazyBeanConfiguration.class);

   /**
    * secara default bean di spring akan di buat ketika applikasi spring pertama kali di run/jalankan
    * oleh karna itu kadang ketika applikasi spring di run akan sedikit lambat hal ini di karnakan 
    * semua bean akan di buat di awal
    * namun jika kita mau kita bisa membuat sebuah bean memnjadi lazy(malas), yang mna bena tidak
    * akan di buat, sampai memang bean tersebut di akses atau di butuhkan 
    * untuk membuat bena menjadi lazy kita hanya perlu menambahkan annotasi @Lazy diatas method bean
    * @return
    */

   @Lazy
   @DependsOn("barLazy")
   @Bean(value = "fooLazy")
   public Foo foo(){
      logger.info("====creating fooLazy====");
      return new Foo();
   }

   @Bean(value = "barLazy")
   public Bar bar(){
      logger.info("====creating barLazy====");
      return new Bar();
   }
   
}
