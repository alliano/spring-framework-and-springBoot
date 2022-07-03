package com.basicconfiguration.spring.core.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainServer {


   private Logger logger = LoggerFactory.getLogger(MainServer.class);

   /**
    * selain menggunakan annotation @Bean untuk menandai sebuah method adalah init method 
    * dan destroy method, kita juga bisa menggunakan annotation pada method nya secara 
    * langsung 
    * ini bisa digunakan untuk menghindari kita lupa untuk menyebutkan init dan destroy
    * method ketika membuat bean 
    * @PostConstruct merupakan method yang ditandai harus dioanggil ketika bean selesai dibuat
    * @Predestroy merupakan method yang ditandai harus dipanggil ketika bean akan dihancurkan
    * jika sudah menggunakan annotation ini kita tidak perlu lagi menyebutkan di @bean
    */
   @PostConstruct
   public void startMainServer(){
      logger.info("****the main server has started****");
   }

   @PreDestroy
   public void stopMainServer(){
      logger.info("****the main server has stoped****");
   }
}
