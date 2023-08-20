package com.basicconfiguration.spring.core.helper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
   
   public void start(){
      log.info("the server has been started");
   }

   public void stop(){
      log.info("the server has been stoped");
   }
}
