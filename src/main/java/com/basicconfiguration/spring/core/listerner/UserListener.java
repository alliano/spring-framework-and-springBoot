package com.basicconfiguration.spring.core.listerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.basicconfiguration.spring.core.event.LogginSuccessEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class UserListener {
   
   private final Logger logger = LoggerFactory.getLogger(UserListener.class);

   /**
    * Selain mengunakan interface ApplicationListener, kita juga bisa menggunakan Annotation untuk 
    * membuat Listener
    * ini lebih fleksibel dibandigkan dengan menggunakan interface ApplicationListener
    * kita bisa menggunakan annotation @EventLikstener
    * @param event
    * 
    * cara kerja annotation @EventListener 
    * Annotation @EventListener bekerja dengan menggunkakan beanPostProcessor bernama EventListenerPostProcessor
    * EventListenerMethodProcessor mendeteksi jika ada bean yang memiliki method dengan annotasi @EventListener
    * maka secara otomatis akan membuat event baru lalu meregistrasikan nya ke ApplicationContex.addApplicationListener(listener)
    * 
    */


   @EventListener(classes = LogginSuccessEvent.class)
   public void onLoginSuccesListener(LogginSuccessEvent event){
      this.logger.info("Success login for user", event.getUser());
   }
}
