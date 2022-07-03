package com.basicconfiguration.spring.core.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
   private Logger logger = LoggerFactory.getLogger(Server.class);

   public void start(){
      logger.info("the server has been started");
   }
   public void stop(){
      logger.info("the server has been stoped");
   }

}
