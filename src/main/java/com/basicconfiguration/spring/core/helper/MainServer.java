package com.basicconfiguration.spring.core.helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainServer {
   /**
    * jika Method di annotasi dengan @PostConstruct maka method tersebut harus dipanggil ketika bean selesai dibuat
    * Jika method di anotasi sebagai @Predestroy maka method tersebut harus dipanggil ketika bean akan dihancurkan
    * jika sudah menggunakan annotation ini kita tidak perlu lagi menyebutkan di @bean
    */
   @PostConstruct
   public void startMainServer(){
      log.info("****the main server has started****");
   }

   @PreDestroy
   public void stopMainServer(){
      log.info("****the main server has stoped****");
   }
}